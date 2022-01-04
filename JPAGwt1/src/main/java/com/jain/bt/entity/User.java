package com.jain.bt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	
	@Id
	private int aid;
	
	private String aname;
	
	
	
	public String getName() {
		return aname;
	}
	public void setName(String aname) {
		this.aname = aname;
	}
	
	}