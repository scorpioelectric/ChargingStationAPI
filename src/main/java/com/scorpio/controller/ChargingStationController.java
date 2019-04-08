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

import com.handler.StationAlreadyExistsException;
import com.handler.StationNotFoundException;
import com.scorpio.entity.ChargingStation;
import com.scorpio.repository.ChargingStationRepository;

@Controller
@RequestMapping(path = "/api")
public class ChargingStationController {
	@Autowired
	ChargingStationRepository chargingStationRepository;

	
	@PostMapping("/addStn")
	public ResponseEntity<Object> createStn(@RequestBody ChargingStation Chargingstn)
			throws StationAlreadyExistsException {
		ChargingStation savedStn = chargingStationRepository.save(Chargingstn);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
			.buildAndExpand(savedStn.getChargingStnID()).toUri();
			return ResponseEntity.created(location).build();
	}

	@GetMapping("/getChargingStnByID/{chargingStnID}")
	@ResponseBody
	public ChargingStation retrieveStationByID(@PathVariable long chargingStnID) throws StationNotFoundException {
		Optional<ChargingStation> ChargingStation = chargingStationRepository.findById(chargingStnID);
		if (!ChargingStation.isPresent())
			throw new StationNotFoundException();
		return ChargingStation.get();

	}
	
	@GetMapping("/getChargingStnByLocation/{AddressLine1}")
	@ResponseBody
	public ChargingStation retrieveStationByLocation(@PathVariable String AddressLine1) throws StationNotFoundException {
		Optional<ChargingStation> ChargingStation = chargingStationRepository.retrieveStationByLocation(AddressLine1);
		if (!ChargingStation.isPresent())
			throw new StationNotFoundException();
		return ChargingStation.get();

	}


	@GetMapping(path = "/getAllChargingStn")
	@ResponseBody
	public List<ChargingStation> findAllStn() {
		StringBuffer retBuf = new StringBuffer();
		List<ChargingStation> stationList = (List<ChargingStation>) chargingStationRepository.findAll();
		return stationList;
	}
	
	@DeleteMapping("/getChargingStnByID/{chargingStnID}")
	public void deleteStation(@PathVariable long chargingStnID) {
		chargingStationRepository.deleteById(chargingStnID);
	}
	
	@PutMapping("/getChargingStnByID/{chargingStnID}")
	public ResponseEntity<Object> updateStation(@RequestBody ChargingStation Chargingstn, @PathVariable long chargingStnID) {

		Optional<ChargingStation> cs = chargingStationRepository.findById(chargingStnID);

		if (!cs.isPresent())
			return ResponseEntity.notFound().build();

		Chargingstn.setChargingStnID(chargingStnID);
		
		chargingStationRepository.save(Chargingstn);

		return ResponseEntity.noContent().build();
	}

}
