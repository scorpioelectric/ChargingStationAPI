package com.scorpio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scorpio.entity.UserAccount;
import com.scorpio.repository.UserAccountRepository;

@Service
public class UserAccountService {
	public <S extends UserAccount> S save(S entity) {
		return useraccountrep.save(entity);
	}

	public <S extends UserAccount> Iterable<S> saveAll(Iterable<S> entities) {
		return useraccountrep.saveAll(entities);
	}

	public Optional<UserAccount> findById(Long id) {
		return useraccountrep.findById(id);
	}

	public boolean existsById(Long id) {
		return useraccountrep.existsById(id);
	}

	public Iterable<UserAccount> findAll() {
		return useraccountrep.findAll();
	}

	public Iterable<UserAccount> findAllById(Iterable<Long> ids) {
		return useraccountrep.findAllById(ids);
	}

	public long count() {
		return useraccountrep.count();
	}

	public void deleteById(Long id) {
		useraccountrep.deleteById(id);
	}

	public void delete(UserAccount entity) {
		useraccountrep.delete(entity);
	}

	public void deleteAll(Iterable<? extends UserAccount> entities) {
		useraccountrep.deleteAll(entities);
	}

	public void deleteAll() {
		useraccountrep.deleteAll();
	}

	@Autowired
	private UserAccountRepository useraccountrep;
	

}
