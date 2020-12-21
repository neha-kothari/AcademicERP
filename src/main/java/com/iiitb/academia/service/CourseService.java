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


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseService {

    CoursesDAO courseDao = new CoursesDAOImpl();
    DomainsDAO domainsDAO = new DomainsDAOImpl();
    SpecialisationDAO specialisationDAO = new SpecialisationDAOImpl();
    EmployeesDAO employeesDAO = new EmployeesDAOImpl();
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

        return employeesDAO.getEmployeeDetailsById(emp_id).getCourses();
    }

    public List<Courses> fetchCoursesBySpecialisation(Integer specialisation_id){

        return specialisationDAO.getSpecialisationDetailsById(specialisation_id).getCourses();
    }

    public List<Courses> fetchCoursesByDomain(Integer domainId){
        return domainsDAO.getDomainById(domainId).getCourses();
    }

   public List<Student_Courses> getAllStudentsDetails(Integer course_id) {
       return courseDao.fetchCourseDetailsById(course_id).getStudent_courses();
   }

    public List<Courses> fetchCoursesByDomainAndSpecialisation(Integer domainId, Integer specialisation_id) {

        List<Courses> domainSpecificList = fetchCoursesByDomain(domainId);
        List<Courses> specialisationSpecificList = fetchCoursesBySpecialisation(specialisation_id);
        List<Courses> intersectDomainSpecialisation = new ArrayList();
        for(Courses domainSpecific : domainSpecificList){
            for(Courses specialisationSpecific : specialisationSpecificList){
                if(domainSpecific.getCourse_id().equals(specialisationSpecific.getCourse_id())){
                    intersectDomainSpecialisation.add(domainSpecific);
                }
            }

        }
        return intersectDomainSpecialisation;

    }

    public List<Courses> fetchCoursesByFacultyAndSpecialisation(Integer emp_id, Integer specialisation_id) {

        List<Courses> facultySpecificList = fetchCoursesByFaculty(emp_id);
        List<Courses> specialisationSpecificList = fetchCoursesBySpecialisation(specialisation_id);
        List<Courses> intersectFacultySpecialisation = new ArrayList<>();
        for(Courses facultySpecific : facultySpecificList){
            for(Courses specialisationSpecific : specialisationSpecificList){
                if(specialisationSpecific.getCourse_id().equals(facultySpecific.getCourse_id())){
                    intersectFacultySpecialisation.add(specialisationSpecific);
                }
            }
        }
        return intersectFacultySpecialisation;

    }
    }
