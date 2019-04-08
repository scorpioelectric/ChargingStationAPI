package com.scorpio.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scorpio.entity.ChargingStation;

@Repository
public interface ChargingStationRepository extends CrudRepository<ChargingStation, Long> {
	

	 public ArrayList<ChargingStation> save(ArrayList<ChargingStation> items);
	 
	 
	 @Query("SELECT T FROM EST_CHARGINGSTN T where AddressLine1 = :loc")
	 Optional<ChargingStation> retrieveStationByLocation(@Param("loc") String loc);
}
