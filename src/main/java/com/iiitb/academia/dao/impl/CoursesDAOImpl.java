package com.iiitb.academia.dao.impl;

import com.iiitb.academia.bean.Courses;
import com.iiitb.academia.bean.Student_Courses;
import com.iiitb.academia.dao.CoursesDAO;
import com.iiitb.academia.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CoursesDAOImpl implements CoursesDAO {

    @Override
    public boolean registerCourse(Courses course) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public List<Courses> getAllCourseDetails() {
        Session session = SessionUtil.getSession();
        List<Courses> courses = new ArrayList<>();
        try {
            for (final Object course : session.createQuery("from Courses ").list()) {
                courses.add((Courses) course);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return courses;
    }

    @Override
    public Courses fetchCourseDetailsById(Integer id) {
        try (Session session = SessionUtil.getSession()) {
            return session.get(Courses.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Courses> fetchCoursesByCapacity(Integer capacity) {
        List<Courses> courses = new ArrayList<>();
        try (Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from Courses where capacity=:capacity");
            query.setParameter("capacity", capacity);
            for (final Object course : query.list()) {
                courses.add((Courses) course);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return courses;
    }

    @Override
    public List<Courses> fetchCoursesByYear(Integer year) {
        List<Courses> courses = new ArrayList<>();
        try (Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from Courses where year=:year");
            query.setParameter("year", year);
            for (final Object course : query.list()) {
                courses.add((Courses) course);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return courses;
    }

    @Override
    public List<Courses> fetchCoursesByYearAndTerm(Integer year, Integer term) {
        List<Courses> courses = new ArrayList<>();
        try (Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from Courses where year=:year and term:=term");
            query.setParameter("year", year);
            query.setParameter("term", term);
            for (final Object course : query.list()) {
                courses.add((Courses) course);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return courses;
    }

}
