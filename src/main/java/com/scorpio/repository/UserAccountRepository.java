package com.scorpio.repository;

import org.springframework.data.repository.CrudRepository;

import com.scorpio.entity.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {


}