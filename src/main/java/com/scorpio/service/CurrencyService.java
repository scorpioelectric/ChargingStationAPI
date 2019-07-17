package com.scorpio.service;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;
import org.hibernate.SessionFactory;

import com.scorpio.entity.Currency;
import com.scorpio.entity.PaymentGateway;
import com.scorpio.repository.CurrencyRepository;

@Service
public class CurrencyService {

	public <C extends Currency> C save(C entity) {
		return currencyrep.save(entity);
	}

	public <S extends Currency> Iterable<S> saveAll(Iterable<S> entities) {
		return currencyrep.saveAll(entities);
	}

	public Optional<Currency> findById(Long id) {
		return currencyrep.findById(id);
	}
	
	public Optional<Currency> findBycIdIgnoreCase(String Currency) {
		return currencyrep.findBycIdIgnoreCase(Currency);
	}

	public Iterable<Currency> findAll() {
		return currencyrep.findAll();
	}

	public long count() {
		return currencyrep.count();
	}

	public void delete(Currency entity) {
		currencyrep.delete(entity);
	}

	public void deleteAll(Iterable<? extends Currency> entities) {
		currencyrep.deleteAll(entities);
	}

	public void deleteAll() {
		currencyrep.deleteAll();
	}
	
	@Autowired
	private CurrencyRepository currencyrep;

}
