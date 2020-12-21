package com.iiitb.academia.controller;

import com.iiitb.academia.bean.Courses;
import com.iiitb.academia.bean.Domains;
import com.iiitb.academia.bean.Employees;
import com.iiitb.academia.bean.Student_Courses;
import com.iiitb.academia.bean.Specialisation;
import com.iiitb.academia.pojo.CourseStudents;
import com.iiitb.academia.pojo.CoursesPOJO;

import java.util.ArrayList;
import java.util.List;

public class CoursesControllerUtil {

    public List<CourseStudents> mapStudentCoursesBeanToPojo(List<Student_Courses> student_courses) {
        List<CourseStudents> result = new ArrayList<>();

        for(int i=0; i<student_courses.size(); i++){
            Student_Courses student_course= student_courses.get(i);
            CourseStudents cs = new CourseStudents();
            cs.setRoll_number(student_course.getStudents().getRoll_number());
            cs.setFull_name(student_course.getStudents().getFirst_name()+ " " +student_course.getStudents().getLast_name());
            cs.setGrade_letter(student_course.getGrade().getLetter_grade());
            cs.setGrade_points(student_course.getGrade().getGrade_points());
            cs.setCgpa(student_course.getStudents().getCgpa());
            result.add(cs);
        }
        return result;
    }
    //@JsonbTransient
    public List<CoursesPOJO> mapCoursesBeanToPojo(List<Courses> courses) {

        List<CoursesPOJO> result = new ArrayList<>();
        for(int i=0; i<courses.size(); i++){
            Courses course= courses.get(i);
            CoursesPOJO cs = new CoursesPOJO();
            cs.setCourse_id(course.getCourse_id());
            cs.setName(course.getName());
            cs.setDescription(course.getDescription());
            cs.setTerm(course.getTerm());
            cs.setCourse_code(course.getCourse_code());
            cs.setCredits(course.getCredits());
            cs.setYear(course.getYear());
            cs.setCapacity(course.getCapacity());
            setFacultyName(cs, course.getEmployee_id());
            setDomains(cs, course.getDomains());
            setSpecialisation(cs, course.getSpecialisations());
            result.add(cs);
        }
        return result;
    }

    private void setFacultyName(CoursesPOJO cs, Employees employee) {

        String faculty_name = employee.getTitle()+". "+employee.getFirst_name()+ " " +  employee.getLast_name();
        cs.setFaculty_name(faculty_name);
    }

    private void setDomains(CoursesPOJO cs, List<Domains> domains) {

        StringBuilder domainsString = new StringBuilder();
        System.out.println("Printing domains-size::"+domains.size());
        for(Domains d : domains){
            System.out.println("Printing::"+d.getProgram());
            domainsString.append(d.getProgram() + "-"+d.getBatch()+", ");

        }
        int len = domainsString.length();
        cs.setDomains(domainsString.substring(0, len-2));

    }

    private void setSpecialisation(CoursesPOJO cs, List<Specialisation> specialisations) {
        StringBuilder specialisationsString = new StringBuilder();
        for(Specialisation s : specialisations){
            specialisationsString.append(s.getName()+", ");
        }
        int len = specialisationsString.length();
        cs.setSpecialisations(specialisationsString.substring(0, len-2));
    }
}
