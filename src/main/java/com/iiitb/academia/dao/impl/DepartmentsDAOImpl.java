package com.iiitb.academia.dao.impl;

import com.iiitb.academia.bean.Departments;
import com.iiitb.academia.dao.DepartmentsDAO;
import com.iiitb.academia.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DepartmentsDAOImpl implements DepartmentsDAO {
    @Override
    public boolean addDepartment(Departments department) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Departments> getDepartments() {
        Session session = SessionUtil.getSession();
        List<Departments> departments = new ArrayList<>();
        try {
            for (final Object dept : session.createQuery("from Departments ").list()) {
                departments.add((Departments) dept);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return departments;
    }

    @Override
    public Departments getDepartmentById(Integer id) {
        Session session = SessionUtil.getSession();
        try {
            return session.get(Departments.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
