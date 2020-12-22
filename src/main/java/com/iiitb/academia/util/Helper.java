package com.iiitb.academia.util;

import com.iiitb.academia.bean.*;
import com.iiitb.academia.dao.*;
import com.iiitb.academia.dao.impl.*;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    /**public static void main(String[] args) {

        System.out.println("Heyy from helper");
        //populateStudentCourses();
        populateDummyData();
    }*/

    public static void populateDummyData(){
        populateGrades();
        populateDomains();
        populateSpecialisation();
        populateDepartments();
        populateEmployees();
        populateCourses();
        populateStudents();
        populateStudentCourses();
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

        Courses c1 = new Courses("Algorithms","Algorithms",4,1, "CS511",2021, 200, e2,
                null, domainsCSE,sCSList);
        Courses c2 = new Courses("System Software","Software Systems - I",2,1, "CS513",2020, 200, e3,
                null, domainsECE,sECList);
        Courses c3 = new Courses("Computer Networks-I","Basics of Computer Networks",4,1, "NC501",2020, 100, e1,
                null, domainsECE,sECList);
        Courses c4 = new Courses("Maths for Machine Learning","Probability",2,1, "AI512",2022, 200, e4,
                null, domainsCSE,sAIList);

        CoursesDAO coursesDAO = new CoursesDAOImpl();
        coursesDAO.registerCourse(c1);
        coursesDAO.registerCourse(c2);
        coursesDAO.registerCourse(c3);
        coursesDAO.registerCourse(c4);
    }


    private static void populateStudents() {

        DomainsDAO domainsDAO = new DomainsDAOImpl();
        Domains MtechCSE = domainsDAO.getDomainById(1);
        Domains MtechECE = domainsDAO.getDomainById(2);
        Domains MSCSE = domainsDAO.getDomainById(3);
        Domains MSECE = domainsDAO.getDomainById(4);

        SpecialisationDAO specialisationDAO = new SpecialisationDAOImpl();
        Specialisation sAI = specialisationDAO.getSpecialisationDetailsById(1);
        Specialisation sCS = specialisationDAO.getSpecialisationDetailsById(2);
        Specialisation sNC = specialisationDAO.getSpecialisationDetailsById(3);
        Specialisation sEC = specialisationDAO.getSpecialisationDetailsById(4);

        CoursesDAO coursesDAO = new CoursesDAOImpl();
        Courses cAlgo = coursesDAO.fetchCourseDetailsById(1);
        Courses cSS = coursesDAO.fetchCourseDetailsById(2);
        Courses cCN = coursesDAO.fetchCourseDetailsById(3);
        Courses cMML = coursesDAO.fetchCourseDetailsById(4);

            Students s1 = new Students( 1, "Cedric", "Diggory","cedric.diggory@iiitb.org", null, 4.0f, 12, 2020, MtechCSE, sAI, null);
            Students s2 = new Students( 2, "Harry", "Potter","harry.potter@iiitb.org", null, 3.2f, 8, 2021, MtechECE, sNC, null);
            Students s3 = new Students( 3, "Ronald", "Weasley","ronald.weasley@iiitb.org", null, 3.0f, 8, 2021, MSECE, sEC, null);
            Students s4 = new Students( 4, "Neville", "Longbottom","neville.longbottom@iiitb.org", null, 3.1f, 4, 2022, MSCSE, sCS, null);
            //not adding Hermione because she would be a student at IIT-Bombay and not IIIT-B
            StudentDAO studentDAO = new StudentDAOImpl();
            studentDAO.addStudent(s1);
            studentDAO.addStudent(s2);
            studentDAO.addStudent(s3);
            studentDAO.addStudent(s4);

            //Student_Courses sc1 = new Student_Courses(s1, c1, g1, "Excellent");
    }

    private static void populateStudentCourses(){

        StudentDAO studentDAO= new StudentDAOImpl();
        Students s1=studentDAO.fetchStudentDetailsById(1);
        Students s2=studentDAO.fetchStudentDetailsById(2);
        Students s3=studentDAO.fetchStudentDetailsById(3);
        Students s4=studentDAO.fetchStudentDetailsById(4);

        CoursesDAO coursesDAO = new CoursesDAOImpl();
        Courses cAlgo = coursesDAO.fetchCourseDetailsById(1);
        Courses cSS = coursesDAO.fetchCourseDetailsById(2);
        Courses cCN = coursesDAO.fetchCourseDetailsById(3);
        Courses cMML = coursesDAO.fetchCourseDetailsById(4);

        GradesDAO gradesDAO = new GradesDAOImpl();
        Grades g1= gradesDAO.getGradeDetailsById(1);
        Grades g2= gradesDAO.getGradeDetailsById(2);
        Grades g3= gradesDAO.getGradeDetailsById(3);
        Grades g4= gradesDAO.getGradeDetailsById(4);
        Grades g5= gradesDAO.getGradeDetailsById(5);
        Grades g6= gradesDAO.getGradeDetailsById(6);

        Student_CoursesDAO student_coursesDAO= new Student_CoursesDAOImpl();

        Student_Courses sc1= new Student_Courses(s1,cAlgo,g1,"None");
        Student_Courses sc2= new Student_Courses(s2,cAlgo,g3,"None");
        Student_Courses sc3= new Student_Courses(s2,cCN,g2,"None");
        Student_Courses sc4= new Student_Courses(s4,cMML,g4,"None");
        Student_Courses sc5= new Student_Courses(s4,cSS,g1,"None");
        Student_Courses sc6= new Student_Courses(s3,cMML,g5,"None");


        student_coursesDAO.addStudentCourses(sc1);
        student_coursesDAO.addStudentCourses(sc2);
        student_coursesDAO.addStudentCourses(sc3);
        student_coursesDAO.addStudentCourses(sc4);
        student_coursesDAO.addStudentCourses(sc5);
        student_coursesDAO.addStudentCourses(sc6);
    }

}
