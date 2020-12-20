package com.iiitb.academia.util;

import com.iiitb.academia.bean.*;
import com.iiitb.academia.dao.DepartmentsDAO;
import com.iiitb.academia.dao.GradesDAO;
import com.iiitb.academia.dao.impl.DepartmentsDAOImpl;
import com.iiitb.academia.dao.impl.GradesDAOImpl;

public class Helper {

    public static void main(String[] args) {

        System.out.println("Heyy from helper");
        populateDummyData();


    }

    public static void populateDummyData(){
        populateGrades();
        populateDomains();
        populateDepartments();
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
        Departments d1 = new Departments("Computer Science & Engineering", 160);
        Departments d2 = new Departments("Electronics & Communication", 50);
        DepartmentsDAO departmentsDAO = new DepartmentsDAOImpl();
        departmentsDAO.addDepartment(d1);
        departmentsDAO.addDepartment(d2);
    }

    public static void populateDomains(){

        Domains d1 = new Domains("MTech","CSE 2020",160, "GATE qualified", null);
        Domains d2 = new Domains("MTech","ECE 2020",50, "GATE qualified", null);
        Domains d3 = new Domains("MS","CSE 2020",20, "GATE qualified", null);
        Domains d4 = new Domains("MS","ECE 2020",20, "GATE qualified", null);

    }
    public static void populateSpecialisation() {
        Specialisation s1 = new Specialisation("AI", "Artificial Intelligence","Machine Learning & Data Science",2,20, null);
        Specialisation s2 = new Specialisation("CS", "Computer Science","Theory of Computer Science & Design",1,20, null);
        Specialisation s3 = new Specialisation("NC", "Networks & Communication","Computer Networks",2,12, null);

    }

    public void populateEmployees() {
        //Departments d1 = DepartmentsDAOImpl.getDepartmentById(1);
        //Employees e1 = new Employees("Jyotsna", "Bapat", "jyotsna.bapat@iiitb.org", "Prof", 1, null);

    }



}
