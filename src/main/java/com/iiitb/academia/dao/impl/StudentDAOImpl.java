package com.iiitb.academia.dao.impl;

import com.iiitb.academia.bean.Students;
import com.iiitb.academia.dao.StudentDAO;
import com.iiitb.academia.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Students student) {

        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(student);
            System.out.println("Student created with id:" + id);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            System.out.print(e.getLocalizedMessage());
            return false;
        }

    }
}
