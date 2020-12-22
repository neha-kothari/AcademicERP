package com.iiitb.academia.dao.impl;

import com.iiitb.academia.bean.Student_Courses;
import com.iiitb.academia.bean.Students;
import com.iiitb.academia.dao.Student_CoursesDAO;
import com.iiitb.academia.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Student_CoursesDAOImpl implements Student_CoursesDAO {
    @Override
    public void addStudentCourses(Student_Courses student_courses) {

        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(student_courses);
            System.out.println("Student courses created with id:" + id);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            System.out.print(e.getLocalizedMessage());
        }

    }

}
