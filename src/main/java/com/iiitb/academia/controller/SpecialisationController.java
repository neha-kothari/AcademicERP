package com.iiitb.academia.controller;

import com.iiitb.academia.bean.Domains;
import com.iiitb.academia.bean.Specialisation;
import com.iiitb.academia.pojo.FilterOptionPojo;
import com.iiitb.academia.service.SpecialisationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

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
    @GET
    @Path("/allpojo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecialisationpojo() {
        List<Specialisation> specialisations = specialisationService.getSpecialisationDetails();
        List<FilterOptionPojo> options = specialisations.stream()
                .map(specialisation-> new FilterOptionPojo(specialisation.getSpecialisation_id(), specialisation.getName() + " "))
                .collect(Collectors.toList());
        return Response.ok().entity(options).build();
    }

}


