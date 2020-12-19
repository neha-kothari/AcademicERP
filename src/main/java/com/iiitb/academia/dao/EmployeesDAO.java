package com.iiitb.academia.dao;

import com.iiitb.academia.bean.Courses;
import com.iiitb.academia.bean.Employees;

import java.util.List;

public interface EmployeesDAO {

    public abstract void addEmployee(Employees employee);
    public abstract List<Employees> getAllEmployeeDetails();
    public abstract Employees getEmployeeDetailsById(Integer id);
    public abstract Employees getEmployeeByEmailId(String email);
}
