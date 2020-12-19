package com.iiitb.academia.controller;

import com.iiitb.academia.bean.Courses;
import com.iiitb.academia.bean.Students;
import com.iiitb.academia.service.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("courses")
public class CoursesController {
    CourseService courseService = new CourseService();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourses() {
        List<Courses> courses = courseService.getAllCourseDetails();
        return Response.ok().entity(courses).build();
    }
    @GET
    @Path("/{courseCode}/students")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsDetails(@PathParam("courseCode") String courseCode) {
        //List<Students> students = courseService.getAllStudentsDetails();
        //return Response.ok().entity(courses).build();
        return null;
    }
    @GET
    @Path("/year/{year}/term/{term}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByYear(@PathParam("year") Integer year, @PathParam("term") Integer term) {
        List<Courses> courses = courseService.fetchCoursesByYearAndTerm(year, term);
        return Response.ok().entity(courses).build();
    }
    @GET
    @Path("/year/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByYear(@PathParam("year") Integer year) {
        List<Courses> courses = courseService.fetchCoursesByYear(year);
        return Response.ok().entity(courses).build();
    }
    @GET
    @Path("/capacity/{capacity}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByCapacity(@PathParam("capacity") Integer capacity) {
        List<Courses> courses = courseService.fetchCoursesByCapacity(capacity);
        return Response.ok().entity(courses).build();
    }

    @GET
    @Path("/faculty/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByFaculty(@PathParam("email") String email) {
        List<Courses> courses = courseService.fetchCoursesByFaculty(email);
        return Response.ok().entity(courses).build();
    }

    @GET
    @Path("/specialisation/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesBySpecialisation(@PathParam("code") String code) {
        List<Courses> courses = courseService.fetchCoursesBySpecialisation(code);
        return Response.ok().entity(courses).build();
    }

    @GET
    @Path("/domain/{program}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByDomain(@PathParam("program") String program) {
        //List<Courses> courses = courseService.fetchCoursesByDomain(program);
        //return Response.ok().entity(courses).build();
        return null;
    }

    @GET
    @Path("/domain/{program}/specialisation/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByDomain(@PathParam("program") String program, @PathParam("code") String code) {
        //List<Courses> courses = courseService.fetchCoursesByFaculty(email);
        //return Response.ok().entity(courses).build();
        return null;
    }

    @GET
    @Path("/faculty/{email}/specialisation/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByFaculty(@PathParam("email") String email,  @PathParam("code") String code) {
        //List<Courses> courses = courseService.fetchCoursesByFaculty(email);
        //return Response.ok().entity(courses).build();
        return null;
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registerCourse(Courses course) throws URISyntaxException {
        if(courseService.registerCourse(course)){
            return Response.ok().build();
        }
        return Response.status(203).build();

    }
}
