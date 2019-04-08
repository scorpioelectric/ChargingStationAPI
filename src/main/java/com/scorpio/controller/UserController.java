package com.scorpio.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scorpio.entity.UserAccount;
import com.scorpio.repository.UserAccountRepository;

@Controller
@RequestMapping(path = "/userspersist")
public class UserController {
	@Autowired
	UserAccountRepository userAccountRepository;

	@RequestMapping(path = "/add")
	@ResponseBody
	public String addUser(@RequestParam String name, @RequestParam String password, @RequestParam String email) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		UserAccount userAccount = new UserAccount();
		userAccount.setName(name);
		userAccount.setPassword(password);
		userAccount.setEmail(email);
		userAccount.setCreatedAt(timestamp);
		userAccount.setUpdatedAt(timestamp);
		
		
		userAccountRepository.save(userAccount);

		String ret = "User account has been added, name = " + name + ", password = " + password + ", email = " + email;

		return ret;

	}

	@GetMapping(path = "/findAll")
	@ResponseBody
	public String findAllUser() {

		StringBuffer retBuf = new StringBuffer();

		List<UserAccount> userAccountList = (List<UserAccount>) userAccountRepository.findAll();

		if (userAccountList != null) {
			for (UserAccount userAccount : userAccountList) {
				retBuf.append("user name = ");
				retBuf.append(userAccount.getName());
				retBuf.append(", password = ");
				retBuf.append(userAccount.getPassword());
				retBuf.append(", email = ");
				retBuf.append(userAccount.getEmail());
				retBuf.append("\r\n");
			}
		}

		if (retBuf.length() == 0) {
			retBuf.append("No record find.");
		} else {
			retBuf.insert(0, "<pre>");
			retBuf.append("</pre>");
		}

		return retBuf.toString();
	}

}
