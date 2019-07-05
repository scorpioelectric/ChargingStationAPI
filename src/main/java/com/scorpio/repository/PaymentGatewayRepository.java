package com.scorpio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scorpio.entity.PaymentGateway;

@Repository
public interface PaymentGatewayRepository extends CrudRepository<PaymentGateway, Long> {

	@Query("SELECT P FROM EST_PAYMENTGW P where Parameter = :Parameter")
	Optional<PaymentGateway> findByValueIgnoreCase(@Param("Parameter") String Parameter);
	
}
