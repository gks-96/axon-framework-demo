package com.gks.event;

import lombok.Getter;

@Getter
public class AccountCreatedEvent {
	
	public AccountCreatedEvent(String id2, String startingBalance2, String status2) {
		this.id = id2; 
		this.startingBalance=startingBalance2;
		this.status= status2; 
	}

	private String id; 
	
	private String status; 
	
	private String startingBalance;

	@Override
	public String toString() {
		return "AccountCreatedEvent [id=" + id + ", status=" + status + ", startingBalance=" + startingBalance + "]";
	} 
	
	
}
