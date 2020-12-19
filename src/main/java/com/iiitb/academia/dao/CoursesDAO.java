package com.iiitb.academia.dao;

import com.iiitb.academia.bean.Courses;
import java.util.List;

public interface CoursesDAO {

    public abstract boolean registerCourse(Courses course);
    public abstract List<Courses> getAllCourseDetails();
    public abstract Courses fetchCourseDetailsById(Integer id);
    public abstract List<Courses> fetchCoursesByCapacity(Integer capacity);
    public abstract List<Courses> fetchCoursesByYear(Integer year);
    public abstract List<Courses> fetchCoursesByYearAndTerm(Integer year, Integer term);
}
