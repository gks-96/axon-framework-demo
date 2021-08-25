package com.gks.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.gks.command.AccountCreatedCommand;
import com.gks.event.AccountCreatedEvent;

@Aggregate
public class AccountAggregate {
	
	@AggregateIdentifier
	private String id; 
	
	@CommandHandler
	public AccountAggregate(AccountCreatedCommand command) {
		System.out.println("inside CommandHandler");
		AggregateLifecycle.apply(new AccountCreatedEvent(command.getId(),command.getStartingBalance(),command.getStatus()));
		
	}
	@EventSourcingHandler
	public void on(AccountCreatedEvent e) {
		this.id = e.getId(); 
		System.out.println("event source handler ");
		
	}
	
	public AccountAggregate(){
		
	}
}
