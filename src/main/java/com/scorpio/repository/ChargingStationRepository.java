package com.scorpio.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scorpio.entity.ChargingStation;

@Repository
public interface ChargingStationRepository extends CrudRepository<ChargingStation, Long> {
	

	 public ArrayList<ChargingStation> save(ArrayList<ChargingStation> items);
	 
	 
}
