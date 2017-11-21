package net.danish.restapp.controller;

import java.util.List;

import net.danish.restapp.model.entity.Trade;
import net.danish.restapp.service.ServiceApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.danish.restapp.dao.TradeDAO;

/**
 * Created by a.danishevskyi on 11/21/17.
 */
@RequestMapping("/trades")
@RestController
public class TradeRestController {
	
	@Autowired
	private TradeDAO tradeDAO;

	@Autowired
	private ServiceApp serviceApp;

	@GetMapping("")
	public List getTrades() {
		return tradeDAO.list();
	}

	@GetMapping("/{id}")
	public ResponseEntity getTrade(@PathVariable("id") Long id) {
		Trade trade = tradeDAO.get(id);
		if (trade == null) {
			return new ResponseEntity("No trade found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(trade, HttpStatus.OK);
	}

	@GetMapping("/valid")
	public List getValidTrades() {
		return tradeDAO.list();
	}

	@GetMapping("/{id}/valid")
	public ResponseEntity getValidTrade(@PathVariable("id") Long id) {
		Trade trade = tradeDAO.get(id);
		if (trade == null) {
			return new ResponseEntity("No crade found for ID " + id, HttpStatus.NOT_FOUND);
		} else if (!serviceApp.isValidQueueDate(trade)){
			return new ResponseEntity("The trade for ID " + id + " is not valid", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(trade, HttpStatus.OK);
	}

	@PostMapping(value = "")
	public ResponseEntity createTrade(@RequestBody Trade trade) {
		tradeDAO.create(trade);
		return new ResponseEntity(trade, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteTrade(@PathVariable Long id) {
		if (null == tradeDAO.delete(id)) {
			return new ResponseEntity("No trade found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity updateTrade(@PathVariable Long id, @RequestBody Trade trade) {
		trade = tradeDAO.update(id, trade);
		if (null == trade) {
			return new ResponseEntity("No trade found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(trade, HttpStatus.OK);
	}

}