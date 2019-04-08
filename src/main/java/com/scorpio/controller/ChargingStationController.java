package com.scorpio.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.scorpio.entity.ChargingStation;
import com.scorpio.repository.ChargingStationRepository;

@Controller
@RequestMapping(path = "/api")
public class ChargingStationController {
	@Autowired
	ChargingStationRepository chargingStationRepository;


	@PostMapping("/addStn")
	public ResponseEntity<Object> createStudent(@RequestBody ChargingStation Chargingstn) {
		ChargingStation savedStn = chargingStationRepository.save(Chargingstn);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStn.getChargingStnID()).toUri();
		return ResponseEntity.created(location).build(); 
	}

	@GetMapping("/getChargingStnByID/{chargingStnID}")
	@ResponseBody
	public ChargingStation retrieveStation(@PathVariable long chargingStnID) {
		Optional<ChargingStation> ChargingStation = chargingStationRepository.findById(chargingStnID);
		return ChargingStation.get();
			
	}

	@GetMapping(path = "/getAllChargingStn")
	@ResponseBody
	public List<ChargingStation> findAllStn() {
		StringBuffer retBuf = new StringBuffer();
		List<ChargingStation> stationList = (List<ChargingStation>) chargingStationRepository.findAll();
		return stationList;
	}
}
