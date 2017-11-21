package net.danish.restapp.model.entity;

import net.danish.restapp.model.base.BaseEntity;

/**
 * Created by a.danishevskyi on 11/21/17.
 */
public class Trade extends BaseEntity {

	private String customer;
	private String ccyPair;
	private String type;
	private String direction;
	private Double amount1;
	private Double amount2;
	private Double rate;
	private String legalEntity;
	private String trader;

	public Trade(long id, String customer, String ccyPair, String type, String direction, String tradeDate, Double amount1, Double amount2, Double rate, String valueDate, String legalEntity, String trader) {
		this.id = id;
		this.customer = customer;
		this.ccyPair = ccyPair;
		this.type = type;
		this.direction = direction;
		this.tradeDate = tradeDate;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.rate = rate;
		this.valueDate = valueDate;
		this.legalEntity = legalEntity;
		this.trader = trader;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCcyPair() {
		return ccyPair;
	}

	public void setCcyPair(String ccyPair) {
		this.ccyPair = ccyPair;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Double getAmount1() {
		return amount1;
	}

	public void setAmount1(Double amount1) {
		this.amount1 = amount1;
	}

	public Double getAmount2() {
		return amount2;
	}

	public void setAmount2(Double amount2) {
		this.amount2 = amount2;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}
}