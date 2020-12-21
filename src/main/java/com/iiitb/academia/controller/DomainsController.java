package com.iiitb.academia.controller;


import com.iiitb.academia.bean.Domains;
import com.iiitb.academia.pojo.FilterOptionPojo;
import com.iiitb.academia.service.DomainsService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("domains")
public class DomainsController {

    DomainsService domainsService = new DomainsService();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDomains() {
        List<Domains> domains = domainsService.getAllDomainsDetails();
        List<FilterOptionPojo> options = domains.stream()
                .map(domain -> new FilterOptionPojo(domain.getDomain_id(), domain.getProgram() + " " + domain.getBatch()))
                .collect(Collectors.toList());
        return Response.ok().entity(options).build();
    }

}
