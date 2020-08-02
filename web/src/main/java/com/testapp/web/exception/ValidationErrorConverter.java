package com.testapp.web.exception;

import com.testapp.web.validation.ValidationError;

public interface ValidationErrorConverter<T> {
    ValidationError toValidationError(T t);
}
