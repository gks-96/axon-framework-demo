package com.gks.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.jpa.DomainEventEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gks.entity.Account;
import com.gks.event.AccountCreatedEvent;
import com.gks.service.AccountService;



@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	private EventStore eventStore; 
	
	
	@PostMapping("api/create-account")
	public void createAccount(@RequestBody Account account) {
		accountService.createAccount(account);
	}
	
	@GetMapping("api/account/{accountId}")
	public List<Object> createAccount(@PathVariable String accountId) {
		
		eventStore.readEvents(accountId).asStream().forEach( s ->{
			 if ( s instanceof AccountCreatedEvent)
			 {
				 AccountCreatedEvent t = (AccountCreatedEvent)s;
				 System.out.println(t);
			 }
		});
		
		return eventStore.readEvents(accountId).asStream().map(s -> 
			s.getPayload()
		).collect(Collectors.toList());
		
		
		
		
		
		
		
		
	}
	
}