package com.iiitb.academia.dao;

import com.iiitb.academia.bean.Grades;

import java.util.List;

public interface GradesDAO {

    boolean addGrade(Grades grade);
    List<Grades> getGradeDetails();
    Grades getGradeDetailsById(Integer id);
}
