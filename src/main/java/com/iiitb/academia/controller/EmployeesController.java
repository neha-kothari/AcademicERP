package com.iiitb.academia.controller;

import com.iiitb.academia.bean.Courses;
import com.iiitb.academia.bean.Employees;
import com.iiitb.academia.service.EmployeesService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("employee")
public class EmployeesController {
    EmployeesService employeesService= new EmployeesService();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees() {
        List<Employees> employees =employeesService.getAllEmployeeDetails();
        return Response.ok().entity(employees).build();
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesByEmail(@PathParam("email") String email) {
        Employees employees =employeesService.fetchEmployeeDetailsByEmail(email);
        return Response.ok().entity(employees).build();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesById(@PathParam("id") Integer id) {
        Employees employees =employeesService.fetchEmployeeDetailsById(id);
        return Response.ok().entity(employees).build();
    }

}
