package com.testapp.web.resource;


import com.testapp.db.model.PhoneCode;
import com.testapp.db.service.PhoneCodeService;
import com.testapp.web.validation.PhoneCodeValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("phoneCodeResource")
public class PhoneCodeResource {

    @Autowired
    private PhoneCodeService phoneCodeService;

    @Autowired
    private PhoneCodeValidator phoneCodeValidator;


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllPhoneCodes")
    public List<PhoneCode> getPhoneCodes() {
        return phoneCodeService.getPhoneCodes();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addPhoneCode")
    public void addPhoneCode(PhoneCode phoneCode) {
        phoneCodeService.add(phoneCode);
    }

}
