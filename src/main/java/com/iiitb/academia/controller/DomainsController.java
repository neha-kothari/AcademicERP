package com.iiitb.academia.controller;


import com.iiitb.academia.bean.Domains;
import com.iiitb.academia.service.DomainsService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("domains")
public class DomainsController {

    DomainsService domainsService = new DomainsService();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDomains() {
        List<Domains> domains = domainsService.getAllDomainsDetails();
        return Response.ok().entity(domains).build();
    }

}
