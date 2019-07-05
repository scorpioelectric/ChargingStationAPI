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

import com.scorpio.entity.PaymentGateway;
import com.scorpio.repository.PaymentGatewayRepository;

@Controller
@RequestMapping(path = "/api")
public class PaymentGatewayController {
	@Autowired
	PaymentGatewayRepository paymentGatewayRepository;
	
	@GetMapping("/getPGByID/{Parameter}")
	@ResponseBody
	public PaymentGateway retrievePGByID(@PathVariable String Parameter) {
		
		Optional<PaymentGateway> PaymentGateway = paymentGatewayRepository.findByValueIgnoreCase(Parameter);

		return PaymentGateway.get();
	}
}