package com.scorpio.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scorpio.entity.ChargingStation;
import com.scorpio.entity.Currency;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

	@Query("SELECT C FROM EST_CURRENCY C where ISO = :Currency")
	Optional<Currency> findBycIdIgnoreCase(@Param("Currency") String Currency); 
	 
}
