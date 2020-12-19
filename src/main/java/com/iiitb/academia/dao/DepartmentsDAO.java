package com.iiitb.academia.dao;

import com.iiitb.academia.bean.Departments;

import java.util.List;

public interface DepartmentsDAO {

    boolean addDepartment(Departments department);
    List<Departments> getDepartments();
    Departments getDepartmentById(Integer id);
}
