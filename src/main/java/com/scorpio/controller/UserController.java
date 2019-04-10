package com.scorpio.controller;

import java.net.URI;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.scorpio.entity.UserAccount;
import com.scorpio.repository.UserAccountRepository;

@Controller
@RequestMapping(path = "/api")
public class UserController {
	@Autowired
	UserAccountRepository userAccountRepository;

	@ResponseBody
	@PostMapping("/addUser")
	public ResponseEntity<Object> createStn(@RequestBody UserAccount userAcc) {
		UserAccount savedAcc = userAccountRepository.save(userAcc);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
			.buildAndExpand(savedAcc.getId()).toUri();
			return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/getUserByID/{id}")
	@ResponseBody
	public UserAccount retrieveUserByID(@PathVariable long id) {
		Optional<UserAccount> UserAccount = userAccountRepository.findById(id);

		return UserAccount.get();

	}

}
