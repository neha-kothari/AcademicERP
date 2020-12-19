package com.iiitb.academia.service;


import com.iiitb.academia.bean.Grades;
import com.iiitb.academia.dao.GradesDAO;
import com.iiitb.academia.dao.impl.GradesDAOImpl;

import java.util.List;

public class GradeService {

    GradesDAO gradesDAO = new GradesDAOImpl();
    public boolean addGrade(Grades grade){
        return gradesDAO.addGrade(grade);
    }

    public List<Grades> getAllCourseDetails(){
        return gradesDAO.getGradeDetails();
    }

    public Grades fetchCourseDetailsById(Integer id){
        return gradesDAO.getGradeDetailsById(id);
    }
}
