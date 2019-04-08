package com.scorpio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "EST_CHARGINGSTN")
public class ChargingStation {

	public ChargingStation(){}
			


	
	  public ChargingStation(int i, String addressLine1, Date lastUpdateTime) {
	  
	  this.AddressLine1=addressLine1; this.LastUpdateTime=lastUpdateTime; }
	 

	/*
	 * @Id
	 * 
	 * @javax.persistence.Column(name = "ChargingStnID")
	 */
	  @GenericGenerator(name="AccountIdGenerator", strategy="org.hibernate.id.enhanced.TableGenerator",
			  parameters = {
			    @Parameter(name="table", value="IdentityGenerator"),
			    @Parameter(name="primary_key_column", value="sequence_name"),
			    @Parameter(name="primary_key_value", value="Account"),
			    @Parameter(name="value_column", value="next_hi_value"),
			    @Parameter(name="primary_key_length", value="100"),
			    @Parameter(name="max_lo", value="1000")
			  }
			)
	  
	  @Id 
	  @GeneratedValue(strategy=GenerationType.TABLE, generator="AccountIdGenerator")
	private Long ChargingStnID;
	public ChargingStation(Long chargingStnID, int active, double port1_Current, double port2_Current,
			double port1_Power, double port2_Power, double port1_Voltage, double port2_Voltage, double port1_Energy,
			double port2_Energy, String port1_Key, String port2_Key, float latitude, float longitude, int gPS_Fix,
			String addressLine1, String addressLine2, int postalCode, Date lastUpdateTime, Date lastStationUpdateTime) {
		super();
		ChargingStnID = chargingStnID;
		Active = active;
		Port1_Current = port1_Current;
		Port2_Current = port2_Current;
		Port1_Power = port1_Power;
		Port2_Power = port2_Power;
		Port1_Voltage = port1_Voltage;
		Port2_Voltage = port2_Voltage;
		Port1_Energy = port1_Energy;
		Port2_Energy = port2_Energy;
		Port1_Key = port1_Key;
		Port2_Key = port2_Key;
		Latitude = latitude;
		Longitude = longitude;
		GPS_Fix = gPS_Fix;
		AddressLine1 = addressLine1;
		AddressLine2 = addressLine2;
		PostalCode = postalCode;
		LastUpdateTime = lastUpdateTime;
		LastStationUpdateTime = lastStationUpdateTime;
	}

	
	@javax.persistence.Column(name = "Active")
	private int Active;
	@javax.persistence.Column(name = "Port1_Current")
	private double Port1_Current;
	@javax.persistence.Column(name = "Port2_Current")
	private double Port2_Current;
	@javax.persistence.Column(name = "Port1_Power")
	private double Port1_Power;
	@javax.persistence.Column(name = "Port2_Power")
	private double Port2_Power;
	@javax.persistence.Column(name = "Port1_Voltage")
	private double Port1_Voltage;
	@javax.persistence.Column(name = "Port2_Voltage")
	private double Port2_Voltage;
	@javax.persistence.Column(name = "Port1_Energy")
	private double Port1_Energy;
	@javax.persistence.Column(name = "Port2_Energy")
	private double Port2_Energy;
	@javax.persistence.Column(name = "Port1_Key")
	private String Port1_Key;
	@javax.persistence.Column(name = "Port2_Key")
	private String Port2_Key;
	@javax.persistence.Column(name = "Latitude")
	private float Latitude;
	@javax.persistence.Column(name = "Longitude")
	private float Longitude;
	@javax.persistence.Column(name = "GPS_Fix")
	private int GPS_Fix;
	@javax.persistence.Column(name = "AddressLine1")
	private String AddressLine1;
	@javax.persistence.Column(name = "AddressLine2")
	private String AddressLine2;
	@javax.persistence.Column(name = "PostalCode")
	private int PostalCode;
	@javax.persistence.Column(name = "LastUpdateTime")
	private Date LastUpdateTime;
	@javax.persistence.Column(name = "LastStationUpdateTime")
	private Date LastStationUpdateTime;

	public Long getChargingStnID() {
		return ChargingStnID;
	}

	public void setChargingStnID(Long chargingStnID) {
		ChargingStnID = chargingStnID;
	}

	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
	}

	public double getPort1_Current() {
		return Port1_Current;
	}

	public void setPort1_Current(double port1_Current) {
		Port1_Current = port1_Current;
	}

	public double getPort2_Current() {
		return Port2_Current;
	}

	public void setPort2_Current(double port2_Current) {
		Port2_Current = port2_Current;
	}

	public double getPort1_Power() {
		return Port1_Power;
	}

	public void setPort1_Power(double port1_Power) {
		Port1_Power = port1_Power;
	}

	public double getPort2_Power() {
		return Port2_Power;
	}

	public void setPort2_Power(double port2_Power) {
		Port2_Power = port2_Power;
	}

	public double getPort1_Voltage() {
		return Port1_Voltage;
	}

	public void setPort1_Voltage(double port1_Voltage) {
		Port1_Voltage = port1_Voltage;
	}

	public double getPort2_Voltage() {
		return Port2_Voltage;
	}

	public void setPort2_Voltage(double port2_Voltage) {
		Port2_Voltage = port2_Voltage;
	}

	public double getPort1_Energy() {
		return Port1_Energy;
	}

	public void setPort1_Energy(double port1_Energy) {
		Port1_Energy = port1_Energy;
	}

	public double getPort2_Energy() {
		return Port2_Energy;
	}

	public void setPort2_Energy(double port2_Energy) {
		Port2_Energy = port2_Energy;
	}

	public String getPort1_Key() {
		return Port1_Key;
	}

	public void setPort1_Key(String port1_Key) {
		Port1_Key = port1_Key;
	}

	public String getPort2_Key() {
		return Port2_Key;
	}

	public void setPort2_Key(String port2_Key) {
		Port2_Key = port2_Key;
	}

	public float getLatitude() {
		return Latitude;
	}

	public void setLatitude(float latitude) {
		Latitude = latitude;
	}

	public float getLongitude() {
		return Longitude;
	}

	public void setLongitude(float longitude) {
		Longitude = longitude;
	}

	public int getGPS_Fix() {
		return GPS_Fix;
	}

	public void setGPS_Fix(int gPS_Fix) {
		GPS_Fix = gPS_Fix;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public int getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(int postalCode) {
		PostalCode = postalCode;
	}

	public Date getLastUpdateTime() {
		return LastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		LastUpdateTime = lastUpdateTime;
	}

	public Date getLastStationUpdateTime() {
		return LastStationUpdateTime;
	}

	public void setLastStationUpdateTime(Date lastStationUpdateTime) {
		LastStationUpdateTime = lastStationUpdateTime;
	}

}
