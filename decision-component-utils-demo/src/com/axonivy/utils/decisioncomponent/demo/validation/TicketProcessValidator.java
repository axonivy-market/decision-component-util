package com.axonivy.utils.decisioncomponent.demo.validation;

import javax.faces.validator.FacesValidator;

import com.axonivy.utils.decisioncomponent.validation.DecisionComponentValidator;


@FacesValidator(value = "ticketProcessValidator")
public class TicketProcessValidator extends DecisionComponentValidator {

}
