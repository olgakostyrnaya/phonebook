package com.testapp.web.resource;


import com.testapp.db.model.PhoneCode;
import com.testapp.db.service.PhoneCodeService;
import com.testapp.web.validation.ValidPhoneCode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("phoneCodeResource")
public class PhoneCodeResource {

    @Autowired
    private PhoneCodeService phoneCodeService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllPhoneCodes")
    public List<PhoneCode> getPhoneCodes() {
        return phoneCodeService.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addPhoneCode")
    public void addPhoneCode(@ValidPhoneCode PhoneCode phoneCode) {
        phoneCodeService.add(phoneCode);
    }

    @DELETE
    @Path("/deleteByCode/{code}")
    public int deleteByCode(@PathParam("code") String code) {
        return phoneCodeService.deleteByCode(code);
    }

    @DELETE
    @Path("/deleteByName/{name}")
    public int deleteByName(@PathParam("name") String name) {
        return phoneCodeService.deleteByName(name);
    }

}
