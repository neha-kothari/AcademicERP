package com.iiitb.academia.controller;

import com.iiitb.academia.bean.Courses;
import com.iiitb.academia.bean.Student_Courses;
import com.iiitb.academia.pojo.CourseStudents;
import com.iiitb.academia.pojo.CoursesPOJO;
import com.iiitb.academia.pojo.FilterOptionPojo;
import com.iiitb.academia.service.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("courses")
public class CoursesController extends CoursesControllerUtil{
    CourseService courseService = new CourseService();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourses() {
        List<Courses> courses = courseService.getAllCourseDetails();
        List<CoursesPOJO> result = mapCoursesBeanToPojo(courses);
        return Response.ok().entity(result).build();
    }
    @GET
    @Path("/years")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getYears() {
        List<Courses> courses = courseService.getAllCourseDetails();
        List<Integer> years = courses.stream()
                .map(course -> course.getYear())
                .distinct()
                .collect(Collectors.toList());
        List<FilterOptionPojo> options = years.stream()
                .map(year -> new FilterOptionPojo(year, String.valueOf(year)))
                .collect(Collectors.toList());
        return Response.ok().entity(options).build();
    }
    @GET
    @Path("/{course_id}/students")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsDetails(@PathParam("course_id") Integer course_id) {
        List<Student_Courses> student_courses = courseService.getAllStudentsDetails(course_id);
        List<CourseStudents> result = mapStudentCoursesBeanToPojo(student_courses);
        return Response.ok().entity(result).build();

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
        List<CoursesPOJO> result = mapCoursesBeanToPojo(courses);
        return Response.ok().entity(result).build();
    }
    @GET
    @Path("/capacity")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCapacity() {
        List<Courses> courses = courseService.getAllCourseDetails();
        List<Integer> capacity = courses.stream()
                .map(course -> course.getCapacity())
                .distinct()
                .collect(Collectors.toList());
        List<FilterOptionPojo> options = capacity.stream()
                .map(capacity1 -> new FilterOptionPojo(capacity1, String.valueOf(capacity1)))
                .collect(Collectors.toList());

        return Response.ok().entity(options).build();
    }
    @GET
    @Path("/capacity/{capacity}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByCapacity(@PathParam("capacity") Integer capacity) {
        List<Courses> courses = courseService.fetchCoursesByCapacity(capacity);
        List<CoursesPOJO> result = mapCoursesBeanToPojo(courses);
        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/faculty/{emp_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByFaculty(@PathParam("emp_id") Integer emp_id) {
        List<Courses> courses = courseService.fetchCoursesByFaculty(emp_id);
        List<CoursesPOJO> result = mapCoursesBeanToPojo(courses);
        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/specialisation/{specialisation_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesBySpecialisation(@PathParam("specialisation_id") Integer specialisation_id) {
        List<Courses> courses = courseService.fetchCoursesBySpecialisation(specialisation_id);
        return Response.ok().entity(courses).build();
    }

    @GET
    @Path("/domain/{domainId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByDomain(@PathParam("domainId") Integer domainId) {
        List<Courses> courses = courseService.fetchCoursesByDomain(domainId);
        List<CoursesPOJO> result = mapCoursesBeanToPojo(courses);
        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/domain/{domainId}/specialisation/{specialisation_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByDomain(@PathParam("domainId") Integer domainId, @PathParam("specialisation_id") Integer specialisation_id) {
        List<Courses> courses = courseService.fetchCoursesByDomainAndSpecialisation(domainId, specialisation_id);
        return Response.ok().entity(courses).build();
    }

    @GET
    @Path("/faculty/{emp_id}/specialisation/{specialisation_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByFaculty(@PathParam("emp_id") Integer emp_id,  @PathParam("specialisation_id") Integer specialisation_id) {
        List<Courses> courses = courseService.fetchCoursesByFacultyAndSpecialisation(emp_id, specialisation_id);
        return Response.ok().entity(courses).build();
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
