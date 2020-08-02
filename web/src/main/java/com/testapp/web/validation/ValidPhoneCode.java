package com.testapp.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneCodeValidator.class)
public @interface ValidPhoneCode {

    String message() default "Invalid code value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
