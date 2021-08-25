package com.gks.service;


import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gks.entity.Account;
import com.gks.event.AccountCreatedEvent;
import com.gks.repository.AccountRepository;

@Component
public class EventHandlingComponent {
	
	@Autowired
	AccountRepository repo; 
	
	@EventHandler 
	public void on(AccountCreatedEvent e ) {
		Account acct = new Account(); 
		acct.setAcccountId(e.getId());
		acct.setStartingBalance(e.getStartingBalance());
		acct.setStatus(e.getStatus());
		repo.save(acct);
		System.out.println("event handler completed ");
	}
}
