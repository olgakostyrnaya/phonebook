package com.testapp.web.validation;


import com.testapp.db.model.PhoneCode;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PhoneCodeValidator implements ConstraintValidator<ValidPhoneCode, PhoneCode> {

    private ValidPhoneCode annotation;

    @Override
    public void initialize(ValidPhoneCode constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(PhoneCode phoneCode, ConstraintValidatorContext constraintValidatorContext) {
        String code = phoneCode.getCode();

        Pattern phoneCodePattern = Pattern.compile("^\\b[0-9]{4,10}$");
        Matcher matcherPhoneCode = phoneCodePattern.matcher(code);

        if (matcherPhoneCode.matches()) {
            return true;
        } else {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(annotation.message()).addConstraintViolation();
        }

        return false;
    }

}
