package com.dayscalc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.dayscalc.model.DateForm;

public class EndDateNotBeforeStartDateValidator implements ConstraintValidator<EndDateNotBeforeStartDate, DateForm> {

	@Override
	public boolean isValid(DateForm dateForm, ConstraintValidatorContext context) {
		if (dateForm.getEndDate().isBefore(dateForm.getStartDate())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
					.addPropertyNode("endDate").addConstraintViolation();
			return false;
		}
		return true;
	}
}
