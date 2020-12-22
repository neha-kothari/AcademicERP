package com.iiitb.academia.dao;

import com.iiitb.academia.bean.Students;

public interface StudentDAO {

    public abstract boolean addStudent(Students student);
    public abstract Students fetchStudentDetailsById(Integer id);

}
