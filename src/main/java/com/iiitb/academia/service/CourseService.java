package com.iiitb.academia.service;
import com.iiitb.academia.bean.Courses;
import com.iiitb.academia.bean.Student_Courses;
import com.iiitb.academia.dao.CoursesDAO;
import com.iiitb.academia.dao.DomainsDAO;
import com.iiitb.academia.dao.EmployeesDAO;
import com.iiitb.academia.dao.SpecialisationDAO;
import com.iiitb.academia.dao.impl.CoursesDAOImpl;
import com.iiitb.academia.dao.impl.DomainsDAOImpl;
import com.iiitb.academia.dao.impl.EmployeesDAOImpl;
import com.iiitb.academia.dao.impl.SpecialisationDAOImpl;


import java.util.List;

public class CourseService {

    CoursesDAO courseDao = new CoursesDAOImpl();
    public boolean registerCourse(Courses course){
        return courseDao.registerCourse(course);
    }

    public List<Courses> getAllCourseDetails(){
        return courseDao.getAllCourseDetails();
    }

    public Courses fetchCourseDetailsById(Integer id){
        return courseDao.fetchCourseDetailsById(id);
    }

    public List<Courses> fetchCoursesByYear(Integer year){
        return courseDao.fetchCoursesByYear(year);
    }

    public List<Courses> fetchCoursesByCapacity(Integer capacity){
        return courseDao.fetchCoursesByCapacity(capacity);
    }

    public List<Courses> fetchCoursesByYearAndTerm(Integer year, Integer term){
        return courseDao.fetchCoursesByYearAndTerm(year, term);
    }

    public List<Courses> fetchCoursesByFaculty(Integer emp_id){
        EmployeesDAO employeesDAO = new EmployeesDAOImpl();
        return employeesDAO.getEmployeeDetailsById(emp_id).getCourses();
    }

    public List<Courses> fetchCoursesBySpecialisation(Integer specialisation_id){
        SpecialisationDAO specialisationDAO = new SpecialisationDAOImpl();
        return specialisationDAO.getSpecialisationDetailsById(specialisation_id).getCourses();
    }

    public List<Courses> fetchCoursesByDomain(Integer domainId){
        DomainsDAO domainsDAO = new DomainsDAOImpl();
        return domainsDAO.getDomainById(domainId).getCourses();
    }

   /** public List<Student_Courses> getAllStudentsDetails(){
        courseDao.
    }*/

}
