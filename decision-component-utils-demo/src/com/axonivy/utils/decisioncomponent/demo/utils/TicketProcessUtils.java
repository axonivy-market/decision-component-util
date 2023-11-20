package com.axonivy.utils.decisioncomponent.demo.utils;

import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;


import ch.ivyteam.ivy.environment.Ivy;

public class TicketProcessUtils {
	
	public static void navigateToHomePage() throws MalformedURLException {
		String statement = "parent.redirectToUrlCommand([{name: 'url', value: '"
				+ URLDecoder.decode(Ivy.html().applicationHomeRef(), StandardCharsets.UTF_8) + "'}])";
		PrimeFaces.current().executeScript(statement);
	}
	
    public static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    public static void reset() {
        PrimeFaces.current().resetInputs("form");
    }

    public static void showInfo() {
    	//reset();
        addMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Save Successfully");
    }

}

