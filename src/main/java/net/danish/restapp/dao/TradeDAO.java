package net.danish.restapp.dao;

import java.util.ArrayList;
import java.util.List;

import net.danish.restapp.model.entity.Trade;
import org.springframework.stereotype.Component;

/**
 * Created by a.danishevskyi on 11/21/17.
 */
@Component
public class TradeDAO {

	// Dummy database. Initialize with some dummy values.
	private static List<Trade> trades;

	{
		trades = new ArrayList();

		trades.add(new Trade(1, "PLUTO1", "EURUSD", "Spot", "BUY",  "2016-08-11", 1000000.00, 1120000.00, 1.12, "2016-08-15", "CS Zurich",  "JohannBaumfiddler"));
		trades.add(new Trade(2, "PLUTO1", "EURUSD", "Spot", "BUY",  "2016-08-11", 1000000.00, 1120000.00, 1.12, "2016-08-15", "CS Zurich",  "JohannBaumfiddler"));
	}

	/**
	 * Returns list of trades from dummy database.
	 * 
	 * @return list of customers
	 */
	public List list() {
		return trades;
	}

	/**
	 * Return trade object for given id from dummy database. If trade is
	 * not found for id, returns null.
	 * 
	 * @param id trade id
	 *
	 * @return trade object for given id
	 */
	public Trade get(Long id) {
		for (Trade trade : trades) {
			if (trade.getId().equals(id)) {
				return trade;
			}
		}
		return null;
	}

	/**
	 * Create new trade in dummy database. Updates the id and insert new
	 * trade in list.
	 * 
	 * @param trade Trade object
	 *
	 * @return trade object with updated id
	 */
	public Trade create(Trade trade) {
		trade.setId(System.currentTimeMillis());
		trades.add(trade);
		return trade;
	}

	/**
	 * Delete the trade object from dummy database. If trade not found for
	 * given id, returns null.
	 * 
	 * @param id the trade id
	 *
	 * @return id of deleted trade object
	 */
	public Long delete(Long id) {
		for (Trade trade : trades) {
			if (trade.getId().equals(id)) {
				trades.remove(trade);
				return id;
			}
		}
		return null;
	}

	/**
	 * Update the trade object for given id in dummy database. If trade
	 * not exists, returns null
	 * 
	 * @param id
	 * @param trade
	 * @return trade object with id
	 */
	public Trade update(Long id, Trade trade) {
		for (Trade t : trades) {
			if (t.getId().equals(id)) {
				trade.setId(t.getId());
				trades.remove(t);
				trades.add(trade);
				return trade;
			}
		}
		return null;
	}

}