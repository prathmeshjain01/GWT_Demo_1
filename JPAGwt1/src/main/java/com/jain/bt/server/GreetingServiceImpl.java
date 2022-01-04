package com.jain.bt.server;




import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jain.bt.client.GreetingService;
import com.jain.bt.ejb.GreetBean;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	
	

	public String greetServer(String input) throws IllegalArgumentException {
		

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);
		String output = null;
		
		//CDI code
		Weld weld = new Weld();
        try (WeldContainer weldContainer = weld.initialize()) {
            output = weldContainer.select(GreetBean.class).get().greet(input ,serverInfo , userAgent  );
        }
		
		//System.out.println(output);

		return output;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
