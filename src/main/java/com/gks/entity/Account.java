package com.gks.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {
	
	@Id
	private String acccountId;
	
	private String status; 
	
	private String startingBalance; 
}
