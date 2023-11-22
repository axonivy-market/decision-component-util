package com.axonivy.utils.decisioncomponent.demo.validation;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.axonivy.utils.decisioncomponent.validation.ValidationUtils;

import ch.ivyteam.ivy.environment.Ivy;


@FacesValidator(value = "ticketProcessValidator")
public class TicketProcessValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		Ivy.log().info("log ticketProcessValidator");
		
		boolean isBooleanCheck = ValidationUtils.isBooleanCheck(component);
		
//		if(ValidationUtils.isSkipValidate(component)) {
//			Ivy.log().info("log ticketProcessValidator 1");
//			return;
//		}
		
		if (ValidationUtils.isValidationRequired(context)) {
			Ivy.log().info("log ticketProcessValidator 4");
			if (isBooleanCheck) {
				Ivy.log().info("log ticketProcessValidator 2");
				ValidationUtils.validateBooleanComponent(component, value);
			} else {
				Ivy.log().info("log ticketProcessValidator 3");
				ValidationUtils.validate(component, value);
			}
		}
	}
	
}
