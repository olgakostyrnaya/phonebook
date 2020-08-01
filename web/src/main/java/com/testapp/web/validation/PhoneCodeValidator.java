package com.testapp.web.validation;


import org.springframework.stereotype.Component;

import javax.json.JsonObject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PhoneCodeValidator implements ConstraintValidator<ValidPhoneCode, javax.json.JsonObject> {

    private ValidPhoneCode validPhoneCode;

    @Override
    public void initialize(ValidPhoneCode constraintAnnotation) {
        this.validPhoneCode = constraintAnnotation;
    }

    @Override
    public boolean isValid(JsonObject jsonObject, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }

}
