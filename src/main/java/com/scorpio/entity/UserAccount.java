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
	


	public UserAccount(long customerID, String UserID, String active, String user_Type, String password_SALT,
			String password_HASH, Date lastLogin, Date verification_Date, String verified, Date createdAt,
			Date updatedAt) {
		super();
		CustomerID = customerID;
		userID = UserID;
		Active = active;
		User_Type = user_Type;
		Password_SALT = password_SALT;
		Password_HASH = password_HASH;
		LastLogin = lastLogin;
		Verification_Date = verification_Date;
		Verified = verified;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CustomerID;
	@javax.persistence.Column(name = "UserID")
    private String userID;
	@javax.persistence.Column(name = "Active")
	private String Active;
	@javax.persistence.Column(name = "User_Type")
	private String User_Type;
    @javax.persistence.Column(name = "Password_SALT")
    private String Password_SALT;
    @javax.persistence.Column(name = "Password_HASH")
    private String Password_HASH;
    @javax.persistence.Column(name = "LastLogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date LastLogin;
    @javax.persistence.Column(name = "Verification_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Verification_Date;
    @javax.persistence.Column(name = "Verified")
    private String Verified;
    @javax.persistence.Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @javax.persistence.Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    	
    public String getActive() {
		return Active;
	}

	public void setActive(String active) {
		Active = active;
	}

	public String getUser_Type() {
		return User_Type;
	}

	public void setUser_Type(String user_Type) {
		User_Type = user_Type;
	}

	public Date getVerification_Date() {
		return Verification_Date;
	}

	public void setVerification_Date(Date verification_Date) {
		Verification_Date = verification_Date;
	}

	public long getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(long customerID) {
		CustomerID = customerID;
	}
	public String getuserID() {
		return userID;
	}
	public void setuserID(String UserID) {
		userID = UserID;
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

	public String getVerified() {
		return Verified;
	}

	public void setVerified(String verified) {
		Verified = verified;
	}
    

}