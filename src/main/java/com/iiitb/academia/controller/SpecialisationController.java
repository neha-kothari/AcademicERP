package com.iiitb.academia.controller;

import com.iiitb.academia.bean.Specialisation;
import com.iiitb.academia.service.SpecialisationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("specialisation")
public class SpecialisationController {
    SpecialisationService specialisationService= new SpecialisationService();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getSpecialisation()
    {
        List<Specialisation> specialisation= specialisationService.getSpecialisationDetails();
        return Response.ok().entity(specialisation).build();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecialisationById(@PathParam("id") Integer id)
    {
        Specialisation specialisation=specialisationService.getSpecialisationDetailsById(id);
        return Response.ok().entity(specialisation).build();
    }

    @GET
    @Path("/code/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByCode(@PathParam("code") String code) {
        Specialisation specialisation= specialisationService.getSpecialisationDetailsByCode(code);
        return Response.ok().entity(specialisation).build();
    }

}


