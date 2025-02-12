package com.iiitb.academia.controller;

import com.iiitb.academia.bean.Courses;
import com.iiitb.academia.bean.Students;
import com.iiitb.academia.service.CourseService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;

//@Path("students")
public class StudentsController {
   /** StudentService studentService = new StudentService();
    CourseService courseService =  new CourseService();
    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerStudent(Students student) throws URISyntaxException {
        System.out.println();
        List<Courses> courses = new ArrayList<>();
        Courses course = courseService.getCourseById(student.getCourses().get(0).getCourse_id());
        if(course!=null){
            courses.add(course);
            student.setCourses(courses);
            if(studentService.registerStudent(student)){
                return Response.ok().build();
            }else{
                return Response.status(203).build();
            }

        }
        return Response.status(203).build();

    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginStudent(Students student) throws URISyntaxException {
        Students result = studentService.verifyEmail(student);
        if(result == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }
    */
}
