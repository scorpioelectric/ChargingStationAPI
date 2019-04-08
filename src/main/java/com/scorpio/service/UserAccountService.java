package com.scorpio.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scorpio.entity.UserAccount;
import com.scorpio.repository.UserAccountRepository;

@Service
public class UserAccountService {
	@Autowired
	private UserAccountRepository useraccountrep;
	
	 public void addUser(String name, String email, String password) {
		 	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        UserAccount acc = new UserAccount();
	        acc.setName(name);
	        acc.setEmail(email);
	        acc.setPassword(password);
	        acc.setCreatedAt(timestamp);
	        acc.setUpdatedAt(timestamp);
	        useraccountrep.save(acc);
	    }
}
