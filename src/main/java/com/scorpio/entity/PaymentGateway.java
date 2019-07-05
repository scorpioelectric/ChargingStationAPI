package com.scorpio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "EST_PAYMENTGW")
public class PaymentGateway {

	public PaymentGateway() {}
	
	public PaymentGateway(long ParameterId, String Parameter, String Value, String Country, Date CreatedAt, Date UpdatedAt) {
		super();
		parameterId = ParameterId;
		parameter=Parameter;
		value=Value;
		country=Country;
		this.createdAt = CreatedAt;
		this.updatedAt = UpdatedAt;
	}
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long parameterId;
	@javax.persistence.Column(name = "Parameter")
    private String parameter;
	@javax.persistence.Column(name = "Value")
    private String value;
	@javax.persistence.Column(name = "Country")
    private String country;
    @javax.persistence.Column(name = "CreatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @javax.persistence.Column(name = "UpdatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    

	public long getParameterId() {
		return parameterId;
	}

	public void setParameterId(long parameterId) {
		this.parameterId = parameterId;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
