package com.jain.bt.ejb;

import java.io.Serializable;

import javax.ejb.Stateless;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import com.jain.bt.cdi.StartupDbService;
import com.jain.bt.shared.FieldVerifier;

@SuppressWarnings("serial")
@Stateless
public class GreetBean implements Serializable {
	
	public  GreetBean() {
		
	}
	
	   public String greet(String input , String serverInfo , String userAgent) {
		   
		// Verify that the input is valid. 
			if (!FieldVerifier.isValidName(input)) {
				// If the input is not valid, throw an IllegalArgumentException back to
				// the client.
				throw new IllegalArgumentException("Name must be at least 4 characters long");
			}
			
			//CDI code
			Weld weld = new Weld();
	        try (WeldContainer weldContainer = weld.initialize()) {
	            weldContainer.select(StartupDbService.class).get().addData(input);
	        }
	        System.out.println("Enter in cdi");
		   
		   return "Hello, " + input + "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are using:<br>"
					+ userAgent+"<br><b>Name Added to database</b>";
	   }
}
