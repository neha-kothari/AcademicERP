package com.iiitb.academia.controller;

import com.iiitb.academia.bean.Courses;
import com.iiitb.academia.bean.Domains;
import com.iiitb.academia.bean.Employees;
import com.iiitb.academia.pojo.FilterOptionPojo;
import com.iiitb.academia.service.EmployeesService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

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

    @GET
    @Path("/allpojo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeePojo() {
        List<Employees> employees = employeesService.getAllEmployeeDetails();
        List<FilterOptionPojo> options = employees.stream()
                .map(employee -> new FilterOptionPojo(employee.getEmployee_id(), employee.getTitle()+" "+employee.getFirst_name() + " " + employee.getLast_name()))
                .collect(Collectors.toList());
        return Response.ok().entity(options).build();
    }

}
