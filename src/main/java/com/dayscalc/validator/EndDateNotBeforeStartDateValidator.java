package com.dayscalc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.dayscalc.model.DateForm;

public class EndDateNotBeforeStartDateValidator implements ConstraintValidator<EndDateNotBeforeStartDate, DateForm> {

	@Override
	public boolean isValid(DateForm dateForm, ConstraintValidatorContext context) {
		if (dateForm.getEndDate() == null || dateForm.getStartDate() == null) {
			return true;
		}
		
		if (dateForm.getEndDate().isBefore(dateForm.getStartDate())) {
			context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
					.addPropertyNode("endDate").addConstraintViolation();
			return false;
		}
		
		return true;
	}
}
