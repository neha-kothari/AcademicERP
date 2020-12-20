package com.iiitb.academia.controller;

import com.iiitb.academia.bean.Courses;
import com.iiitb.academia.bean.Student_Courses;
import com.iiitb.academia.pojo.CourseStudents;
import com.iiitb.academia.service.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
    @Path("/{course_id}/students")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsDetails(@PathParam("course_id") Integer course_id) {
        List<Student_Courses> student_courses = courseService.getAllStudentsDetails(course_id);
        List<CourseStudents> result = mapStudentCoursesBeanToPojo(student_courses);
        return Response.ok().entity(result).build();

    }

    private List<CourseStudents> mapStudentCoursesBeanToPojo(List<Student_Courses> student_courses) {
        List<CourseStudents> result = new ArrayList<>();

        for(int i=0; i<student_courses.size(); i++){
            Student_Courses student_course= student_courses.get(i);
            CourseStudents cs = new CourseStudents();
            cs.setRoll_number(student_course.getStudents().getRoll_number());
            cs.setFirst_name(student_course.getStudents().getFirst_name());
            cs.setLast_name(student_course.getStudents().getLast_name());
            cs.setGrade_letter(student_course.getGrade().getLetter_grade());
            cs.setGrade_points(student_course.getGrade().getGrade_points());
            result.add(cs);
        }
        return result;
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
    @Path("/faculty/{emp_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByFaculty(@PathParam("emp_id") Integer emp_id) {
        List<Courses> courses = courseService.fetchCoursesByFaculty(emp_id);
        return Response.ok().entity(courses).build();
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
        return Response.ok().entity(courses).build();
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
