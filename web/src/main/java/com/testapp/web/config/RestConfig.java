package com.testapp.web.config;

import com.testapp.web.exception.ConstraintViolationExceptionMapper;
import com.testapp.web.exception.DataIntegrityViolationExceptionMapper;
import com.testapp.web.resource.PhoneCodeResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class RestConfig extends ResourceConfig {

    public RestConfig() {
        register(PhoneCodeResource.class);
        register(ConstraintViolationExceptionMapper.class);
        register(DataIntegrityViolationExceptionMapper.class);
    }
}
