package com.iiitb.academia.dao.impl;

import com.iiitb.academia.bean.Courses;
import com.iiitb.academia.bean.Employees;
import com.iiitb.academia.dao.EmployeesDAO;
import com.iiitb.academia.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDAOImpl implements EmployeesDAO {

    @Override
    public void addEmployee(Employees employee) {
        try(Session session = SessionUtil.getSession())
        {
            session.beginTransaction();
            Integer id  = (Integer)session.save(employee);
            System.out.println("Employee created with id:"+id);
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            System.out.print(e.getLocalizedMessage());
        }
    }

    @Override
    public List<Employees> getAllEmployeeDetails() {
        Session session = SessionUtil.getSession();
        List<Employees> employees = new ArrayList<>();
        try {
            for (final Object faculty : session.createQuery("from Employees ").list()) {
                employees.add((Employees) faculty);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return employees;
    }

    @Override
    public Employees getEmployeeDetailsById(Integer id) {
        try (Session session = SessionUtil.getSession()) {
            return session.get(Employees.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Employees getEmployeeByEmailId(String email) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Employees where email like :email");
            query.setParameter("email", email);
            for (final Object fetch : query.list()) {
                return (Employees) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
}
