package com.scorpio.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.scorpio.entity.UserAccount;
import com.scorpio.repository.UserAccountRepository;

@Controller
@RequestMapping(path = "/api")
public class UserAccountController {
	@Autowired
	UserAccountRepository UserAccountRepository;

	@ResponseBody
	@PostMapping("/addUser")
	public ResponseEntity<Object> createUserAcc(@RequestBody UserAccount userAcc) {
		UserAccount savedAcc = UserAccountRepository.save(userAcc);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
			.buildAndExpand(savedAcc.getuserID()).toUri();
			return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/getUserByID/{CustomerID}")
	@ResponseBody
	public UserAccount retrieveUserByID(@PathVariable long CustomerID) {
		Optional<UserAccount> UserAccount = UserAccountRepository.findById(CustomerID);

		return UserAccount.get();
	}
	
	
	@DeleteMapping("/getUserByID/{CustomerID}")
	public void deleteUser(@PathVariable long CustomerID) {
		UserAccountRepository.deleteById(CustomerID);
	}

	@PutMapping("/getUserByID/{CustomerID}")
	public ResponseEntity<Object> updateUser(@RequestBody UserAccount ua, @PathVariable long CustomerID) {

		Optional<UserAccount> obj = UserAccountRepository.findById(CustomerID);

		if (!obj.isPresent())
			return ResponseEntity.notFound().build();

		ua.setCustomerID(CustomerID);
		
		UserAccountRepository.save(ua);

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getUserByUserID/{userID}")
	@ResponseBody
	public UserAccount retrieveUserByuserID(@PathVariable String userID) {
		Optional<UserAccount> UserAccount = UserAccountRepository.findByUserIDIgnoreCase(userID);

		return UserAccount.get();
	}
	


}
