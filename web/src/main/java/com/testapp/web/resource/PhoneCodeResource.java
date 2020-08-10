package com.testapp.web.resource;


import com.testapp.db.model.PhoneCode;
import com.testapp.db.service.PhoneCodeService;
import com.testapp.web.validation.ValidPhoneCode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("phone_code")
public class PhoneCodeResource {

    @Autowired
    private PhoneCodeService phoneCodeService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public void add(@ValidPhoneCode PhoneCode phoneCode) {
        phoneCodeService.add(phoneCode);
    }

    @DELETE
    @Path("/delete")
    public void delete(@QueryParam("code") String code, @QueryParam("name") String name) {
        if (code != null) {
            phoneCodeService.deleteByCode(code);
        }

        if (name != null) {
            phoneCodeService.deleteByName(name);
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    public List<PhoneCode> search(@QueryParam("mask") String mask) {
        if (mask == null) {
            return phoneCodeService.findAll();
        }

        return phoneCodeService.findByCodeContains(mask);
    }
}
