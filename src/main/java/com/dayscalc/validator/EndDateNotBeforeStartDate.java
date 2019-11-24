package com.dayscalc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = EndDateNotBeforeStartDateValidator.class)
@Documented
public @interface EndDateNotBeforeStartDate {

	String message() default "{dateForm.endDate.before.startDate}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
