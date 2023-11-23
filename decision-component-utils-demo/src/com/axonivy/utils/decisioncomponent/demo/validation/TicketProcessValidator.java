package com.axonivy.utils.decisioncomponent.demo.validation;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.axonivy.utils.decisioncomponent.validation.ValidationUtils;


@FacesValidator(value = "ticketProcessValidator")
public class TicketProcessValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		boolean isBooleanCheck = ValidationUtils.isBooleanCheck(component);
		
		if (ValidationUtils.isValidationRequired(context)) {
			if (isBooleanCheck) {
				ValidationUtils.validateBooleanComponent(component, value);
			} else {
				ValidationUtils.validate(component, value);
			}
		}
	}
	
}
