package com.scorpio.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.handler.StationAlreadyExistsException;
import com.scorpio.entity.ChargingStation;
import com.scorpio.repository.ChargingStationRepository;

@Controller
@RequestMapping(path = "/api")
public class ChargingStationController {
	@Autowired
	ChargingStationRepository chargingStationRepository;

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Station Not Found")
	public class StationNotFoundException extends Exception {
		private static final long serialVersionUID = 1L;
	}
	
	@PostMapping("/addStn")
	public ResponseEntity<Object> createStn(@RequestBody ChargingStation Chargingstn)
			throws StationAlreadyExistsException {
		ChargingStation savedStn = chargingStationRepository.save(Chargingstn);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
				.buildAndExpand(savedStn.getChargingStnID()).toUri();
		try {
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			throw new StationAlreadyExistsException();
		}
	}

	@GetMapping("/getChargingStnByID/{chargingStnID}")
	@ResponseBody
	public ChargingStation retrieveStation(@PathVariable long chargingStnID) throws StationNotFoundException {
		Optional<ChargingStation> ChargingStation = chargingStationRepository.findById(chargingStnID);
		
		if (ChargingStation == null) throw new StationNotFoundException();
		
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
