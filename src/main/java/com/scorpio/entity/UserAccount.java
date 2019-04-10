package com.scorpio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "EST_USERACC")
public class UserAccount {

	public UserAccount() {}
	
    public UserAccount(long customerID, String userID, String gOOGLE_CLIENT_ID, String tWITTER_CLIENT_ID,
			String fACEBOOK_CLIENT_ID, String password_SALT, String password_HASH, Date lastLogin, Date createdAt,
			Date updatedAt) {
		super();
		CustomerID = customerID;
		UserID = userID;
		GOOGLE_CLIENT_ID = gOOGLE_CLIENT_ID;
		TWITTER_CLIENT_ID = tWITTER_CLIENT_ID;
		FACEBOOK_CLIENT_ID = fACEBOOK_CLIENT_ID;
		Password_SALT = password_SALT;
		Password_HASH = password_HASH;
		LastLogin = lastLogin;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CustomerID;
	@javax.persistence.Column(name = "UserID")
    private String UserID;
    @javax.persistence.Column(name = "GOOGLE_CLIENT_ID")
    private String GOOGLE_CLIENT_ID;
    @javax.persistence.Column(name = "TWITTER_CLIENT_ID")
    private String TWITTER_CLIENT_ID;
    @javax.persistence.Column(name = "FACEBOOK_CLIENT_ID")
    private String FACEBOOK_CLIENT_ID;
    @javax.persistence.Column(name = "Password_SALT")
    private String Password_SALT;
    @javax.persistence.Column(name = "Password_HASH")
    private String Password_HASH;
    @javax.persistence.Column(name = "LastLogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date LastLogin;
    @javax.persistence.Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @javax.persistence.Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
	public long getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(long customerID) {
		CustomerID = customerID;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getGOOGLE_CLIENT_ID() {
		return GOOGLE_CLIENT_ID;
	}
	public void setGOOGLE_CLIENT_ID(String gOOGLE_CLIENT_ID) {
		GOOGLE_CLIENT_ID = gOOGLE_CLIENT_ID;
	}
	public String getTWITTER_CLIENT_ID() {
		return TWITTER_CLIENT_ID;
	}
	public void setTWITTER_CLIENT_ID(String tWITTER_CLIENT_ID) {
		TWITTER_CLIENT_ID = tWITTER_CLIENT_ID;
	}
	public String getFACEBOOK_CLIENT_ID() {
		return FACEBOOK_CLIENT_ID;
	}
	public void setFACEBOOK_CLIENT_ID(String fACEBOOK_CLIENT_ID) {
		FACEBOOK_CLIENT_ID = fACEBOOK_CLIENT_ID;
	}
	public String getPassword_SALT() {
		return Password_SALT;
	}
	public void setPassword_SALT(String password_SALT) {
		Password_SALT = password_SALT;
	}
	public String getPassword_HASH() {
		return Password_HASH;
	}
	public void setPassword_HASH(String password_HASH) {
		Password_HASH = password_HASH;
	}
	public Date getLastLogin() {
		return LastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		LastLogin = lastLogin;
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