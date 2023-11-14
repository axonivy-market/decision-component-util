package com.axonivy.utils.decisioncomponent.validation;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.axonivy.utils.decisioncomponent.utils.ValidationUtils;


@FacesValidator(value = "decisionComponentValidator")
public class DecisionComponentValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		boolean isBooleanCheck = ValidationUtils.isBooleanCheck(component);
		if(ValidationUtils.isSkipValidate(component)) {
			return;
		}
		
		if (ValidationUtils.isValidationRequired(context)) {
			if (isBooleanCheck) {
				ValidationUtils.validateBooleanComponent(component, value);
			} else {
				ValidationUtils.validate(component, value);
			}
		}
	}
	
}
