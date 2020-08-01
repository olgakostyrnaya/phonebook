package com.testapp.web.resource;


import com.testapp.db.model.PhoneCode;
import com.testapp.db.service.PhoneCodeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("phoneCodeResource")
public class PhoneCodeResource {

    @Autowired
    private PhoneCodeService phoneCodeService;

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/getAllPhoneCodes")
    public List<PhoneCode> getPhoneCodes() {
        return phoneCodeService.getPhoneCodes();
    }

}
