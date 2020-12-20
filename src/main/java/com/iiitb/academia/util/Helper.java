package com.iiitb.academia.util;

import com.iiitb.academia.bean.*;
import com.iiitb.academia.dao.*;
import com.iiitb.academia.dao.impl.*;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static void main(String[] args) {

        System.out.println("Heyy from helper");
        populateDummyData();
    }

    public static void populateDummyData(){
        populateGrades();
        populateDomains();
        populateSpecialisation();
        populateDepartments();
        populateEmployees();
        populateCourses();
    }

    public static void populateGrades(){
        Grades g1 = new Grades("A",10,"Outstanding");
        Grades g2 = new Grades("A-",9,"Excellent");
        Grades g3 = new Grades("B+",8,"Good");
        Grades g4 = new Grades("B",7,"Average");
        Grades g5 = new Grades("B-",6,"Bad");
        Grades g6 = new Grades("C",5,"Very Bad");
        GradesDAO gradesDAO = new GradesDAOImpl();

        gradesDAO.addGrade(g1);
        gradesDAO.addGrade(g2);
        gradesDAO.addGrade(g3);
        gradesDAO.addGrade(g4);
        gradesDAO.addGrade(g5);
        gradesDAO.addGrade(g6);
    }
    public static void populateDepartments() {
        Departments d1 = new Departments("Computer Science & Engineering", 300);
        Departments d2 = new Departments("Electronics & Communication", 150);
        DepartmentsDAO departmentsDAO = new DepartmentsDAOImpl();
        departmentsDAO.addDepartment(d1);
        departmentsDAO.addDepartment(d2);
    }

    public static void populateDomains(){

        Domains d1 = new Domains("MTech","CSE 2020",160, "GATE qualified", null);
        Domains d2 = new Domains("MTech","ECE 2020",50, "GATE qualified", null);
        Domains d3 = new Domains("MS","CSE 2020",20, "GATE qualified", null);
        Domains d4 = new Domains("MS","ECE 2020",20, "GATE qualified", null);
        DomainsDAO domainsDAO = new DomainsDAOImpl();
        domainsDAO.addDomain(d1);
        domainsDAO.addDomain(d2);
        domainsDAO.addDomain(d3);
        domainsDAO.addDomain(d4);

    }
    public static void populateSpecialisation() {
        Specialisation s1 = new Specialisation("AI", "Artificial Intelligence","Machine Learning & Data Science",2,20, null);
        Specialisation s2 = new Specialisation("CS", "Computer Science","Theory of Computer Science & Design",1,20, null);
        Specialisation s3 = new Specialisation("NC", "Networks & Communication","Computer Networks",2,12, null);
        Specialisation s4 = new Specialisation("EC", "Electronics & Communication","Theory of Electronics & Communication & Design",1,20, null);
        SpecialisationDAO specialisationDAO = new SpecialisationDAOImpl();
        specialisationDAO.addSpecialisation(s1);
        specialisationDAO.addSpecialisation(s2);
        specialisationDAO.addSpecialisation(s3);
        specialisationDAO.addSpecialisation(s4);
    }

    public static void populateEmployees() {
        DepartmentsDAO deptDAO = new DepartmentsDAOImpl();
        Departments d1 = deptDAO.getDepartmentById(1);
        Departments d2 = deptDAO.getDepartmentById(2);
        Employees e1 = new Employees("Jyotsna", "Bapat", "jyotsna.bapat@iiitb.org", "Prof", null, d1, null);
        Employees e2 = new Employees("Muralidhara", "VN", "muralidhara.vn@iiitb.org", "Prof", null, d1, null);
        Employees e3 = new Employees("Thangaraju", "B", "thangaraju.b@iiitb.org", "Prof", null, d2, null);
        Employees e4 = new Employees("Ramasubramanian", "V", "ramasubramanian.v@iiitb.org", "Prof", null, d1, null);
        EmployeesDAO employeesDAO = new EmployeesDAOImpl();
        employeesDAO.addEmployee(e1);
        employeesDAO.addEmployee(e2);
        employeesDAO.addEmployee(e3);
        employeesDAO.addEmployee(e4);
    }

    public static void populateCourses() {
        EmployeesDAO employeesDAO = new EmployeesDAOImpl();
        Employees e1 = employeesDAO.getEmployeeDetailsById(1);
        Employees e2 = employeesDAO.getEmployeeDetailsById(2);
        Employees e3 = employeesDAO.getEmployeeDetailsById(3);
        Employees e4 = employeesDAO.getEmployeeDetailsById(4);

        DomainsDAO domainsDAO = new DomainsDAOImpl();
        Domains MtechCSE = domainsDAO.getDomainById(1);
        Domains MtechECE = domainsDAO.getDomainById(2);
        Domains MSCSE = domainsDAO.getDomainById(3);
        Domains MSECE = domainsDAO.getDomainById(4);
        List<Domains> domainsCSE = new ArrayList<>();
        domainsCSE.add(MtechCSE);
        domainsCSE.add(MSCSE);
        List<Domains> domainsECE = new ArrayList<>();
        domainsECE.add(MtechECE);
        domainsECE.add(MSECE);

        SpecialisationDAO specialisationDAO = new SpecialisationDAOImpl();
        Specialisation sAI = specialisationDAO.getSpecialisationDetailsById(1);
        Specialisation sCS = specialisationDAO.getSpecialisationDetailsById(2);
        Specialisation sNC = specialisationDAO.getSpecialisationDetailsById(3);
        Specialisation sEC = specialisationDAO.getSpecialisationDetailsById(4);

        List<Specialisation> sAIList = new ArrayList<>();
        sAIList.add(sAI);
        
        List<Specialisation> sECList = new ArrayList<>();
        sECList.add(sEC);
        sECList.add(sNC);

        List<Specialisation> sCSList = new ArrayList<>();
        sCSList.add(sCS);
        sCSList.add(sNC);

        Courses c1 = new Courses("Algorithms","Algorithms",4,1, "CS511",2020, 200, e2,
                null, domainsCSE,sCSList);
        Courses c2 = new Courses("System Software","Software Systems - I",2,1, "CS513",2020, 200, e3,
                null, domainsECE,sECList);
        Courses c3 = new Courses("Computer Networks-I","Basics of Computer Networks",4,1, "NC501",2020, 100, e1,
                null, domainsECE,sECList);
        Courses c4 = new Courses("Maths for Machine Learning","Probability",2,1, "AI512",2020, 200, e4,
                null, domainsCSE,sAIList);

        CoursesDAO coursesDAO = new CoursesDAOImpl();
        coursesDAO.registerCourse(c1);
        coursesDAO.registerCourse(c2);
        coursesDAO.registerCourse(c3);
        coursesDAO.registerCourse(c4);
    }



}
