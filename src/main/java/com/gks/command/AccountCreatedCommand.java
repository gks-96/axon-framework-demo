package com.gks.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Getter;

@Getter
public class AccountCreatedCommand {
	
	@TargetAggregateIdentifier
	private String id; 
	
	private String status; 
	
	private String startingBalance;

	public AccountCreatedCommand(String id, String status, String startingBalance) {
		
		this.id = id;
		this.status = status;
		this.startingBalance = startingBalance;
	} 

	
}
