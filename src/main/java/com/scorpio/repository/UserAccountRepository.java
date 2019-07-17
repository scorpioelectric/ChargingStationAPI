package com.scorpio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.scorpio.entity.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

	Optional<UserAccount> findByUserIDIgnoreCase(String UserID);
}