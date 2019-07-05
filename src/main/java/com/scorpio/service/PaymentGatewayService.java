package com.scorpio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scorpio.entity.PaymentGateway;
import com.scorpio.repository.PaymentGatewayRepository;

@Service

public class PaymentGatewayService {
	public <S extends PaymentGateway> S save(S entity) {
		return paymentgatewayrep.save(entity);
	}

	public <S extends PaymentGateway> Iterable<S> saveAll(Iterable<S> entities) {
		return paymentgatewayrep.saveAll(entities);
	}

	public Optional<PaymentGateway> findById(Long id) {
		return paymentgatewayrep.findById(id);
	}
	
	public Optional<PaymentGateway> findByValueIgnoreCase(String parameter) {
		return paymentgatewayrep.findByValueIgnoreCase(parameter);
	}

	public boolean existsById(Long id) {
		return paymentgatewayrep.existsById(id);
	}

	public Iterable<PaymentGateway> findAll() {
		return paymentgatewayrep.findAll();
	}

	public Iterable<PaymentGateway> findAllById(Iterable<Long> ids) {
		return paymentgatewayrep.findAllById(ids);
	}

	public long count() {
		return paymentgatewayrep.count();
	}

	public void deleteById(Long id) {
		paymentgatewayrep.deleteById(id);
	}

	public void delete(PaymentGateway entity) {
		paymentgatewayrep.delete(entity);
	}

	public void deleteAll(Iterable<? extends PaymentGateway> entities) {
		paymentgatewayrep.deleteAll(entities);
	}

	public void deleteAll() {
		paymentgatewayrep.deleteAll();
	}

	@Autowired
	private PaymentGatewayRepository paymentgatewayrep;
	

}
