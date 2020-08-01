package com.testapp.web.config;

import com.testapp.web.resource.PhoneCodeResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RestConfig extends ResourceConfig {

    public RestConfig(Class<?>... classes) {
        register(PhoneCodeResource.class);
    }
}
