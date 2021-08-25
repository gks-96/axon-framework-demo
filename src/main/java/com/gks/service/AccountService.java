package com.gks.service;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gks.command.AccountCreatedCommand;
import com.gks.entity.Account;

@Service
public class AccountService {
	
	@Autowired 
	CommandGateway commandGateway; 
	
	public void createAccount(Account account) {
		commandGateway.send(new AccountCreatedCommand(account.getAcccountId(),account.getStartingBalance(),account.getStatus()));
		
	}
	
	
	
	
}
