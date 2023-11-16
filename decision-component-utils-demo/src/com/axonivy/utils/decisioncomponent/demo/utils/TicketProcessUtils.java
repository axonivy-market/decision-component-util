package com.axonivy.utils.decisioncomponent.demo.utils;

import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.primefaces.PrimeFaces;


import ch.ivyteam.ivy.environment.Ivy;

public class TicketProcessUtils {
	
	public static void navigateToHomePage() throws MalformedURLException {
		String statement = "parent.redirectToUrlCommand([{name: 'url', value: '"
				+ URLDecoder.decode(Ivy.html().applicationHomeRef(), StandardCharsets.UTF_8) + "'}])";
		PrimeFaces.current().executeScript(statement);
	}

}
