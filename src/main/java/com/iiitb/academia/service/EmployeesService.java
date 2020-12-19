package com.iiitb.academia.service;

import com.iiitb.academia.bean.Employees;
import com.iiitb.academia.dao.EmployeesDAO;
import com.iiitb.academia.dao.impl.EmployeesDAOImpl;

import java.util.List;

public class EmployeesService {

    EmployeesDAO employeesDAO = new EmployeesDAOImpl();
    public void registerCourse(Employees employee){
        employeesDAO.addEmployee(employee);
    }

    public List<Employees> getAllEmployeeDetails(){
        return employeesDAO.getAllEmployeeDetails();
    }

    public Employees fetchEmployeeDetailsById(Integer id){
        return employeesDAO.getEmployeeDetailsById(id);
    }
    public Employees fetchEmployeeDetailsByEmail(String email){
        return employeesDAO.getEmployeeByEmailId(email);
    }
}
