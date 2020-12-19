package com.iiitb.academia.dao.impl;

import com.iiitb.academia.bean.Grades;
import com.iiitb.academia.dao.GradesDAO;
import com.iiitb.academia.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class GradesDAOImpl implements GradesDAO {
    @Override
    public boolean addGrade(Grades grade) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(grade);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Grades> getGradeDetails() {
        Session session = SessionUtil.getSession();
        List<Grades> grades = new ArrayList<>();
        try {
            for (final Object grade : session.createQuery("from Grades ").list()) {
                grades.add((Grades) grade);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return grades;
    }

    @Override
    public Grades getGradeDetailsById(Integer id) {
        try (Session session = SessionUtil.getSession()) {
            return session.get(Grades.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
