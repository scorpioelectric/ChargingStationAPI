package com.scorpio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "EST_CURRENCY")
public class Currency {
	public Currency() {}
	
	public Currency(String CurrencyId, long CountryId, double CurrencyRate, Date CreatedAt, Date UpdatedAt) {
		super();
		ISO=CurrencyId;
		currencyRate=CurrencyRate;
	}
	
	public String getISO() {
		return ISO;
	}

	public void setISO(String iSO) {
		ISO = iSO;
	}

	public double getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}

	@Id
	@javax.persistence.Column(name = "ISO")
    private String ISO;
	@javax.persistence.Column(name = "CurrencyRate")
    private double currencyRate;

    
}
