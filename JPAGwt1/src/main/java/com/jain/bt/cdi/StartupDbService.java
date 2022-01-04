package com.jain.bt.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class StartupDbService {
	
	@Inject
	Dbservice service1;
	
	public void addData(String name) {
		service1.addData(name);
	}

}