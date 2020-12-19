package com.iiitb.academia.util;

import com.iiitb.academia.bean.*;
import com.iiitb.academia.dao.DepartmentsDAO;
import com.iiitb.academia.dao.GradesDAO;
import com.iiitb.academia.dao.impl.DepartmentsDAOImpl;
import com.iiitb.academia.dao.impl.GradesDAOImpl;
import com.iiitb.academia.service.GradeService;

public class Helper {

    public static void main(String[] args) {

        System.out.println("heyy from helper");

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


        //Specialisation s1 = new Specialisation("AI", "Artificial Intelligence","Machine Learning & Data Science",2,20);
        //Specialisation s2 = new Specialisation("CS", "Computer Science","Theory of Computer Science & Design",1,20);
        //Specialisation s3 = new Specialisation("NC", "Networks & Communication","Computer Networks",2,12);
    }
}
