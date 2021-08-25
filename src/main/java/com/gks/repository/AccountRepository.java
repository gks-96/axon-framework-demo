package com.gks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gks.entity.Account;


public interface AccountRepository extends JpaRepository<Account,String> {

}
