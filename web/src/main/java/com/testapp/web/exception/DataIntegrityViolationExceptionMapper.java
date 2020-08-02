package com.testapp.web.exception;

import com.testapp.web.validation.ValidationError;
import org.springframework.dao.DataIntegrityViolationException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Маппер исключений {@link DataIntegrityViolationExceptionMapper} в {@link ValidationError}
 */
@Provider
public class DataIntegrityViolationExceptionMapper implements ExceptionMapper<DataIntegrityViolationException>,
        ValidationErrorConverter<DataIntegrityViolationException> {

    @Override
    public Response toResponse(DataIntegrityViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(toValidationError(exception))
                .type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    public ValidationError toValidationError(DataIntegrityViolationException exception) {
        ValidationError error = new ValidationError();
        error.setMessage(exception.getMessage());
        return error;
    }

}
