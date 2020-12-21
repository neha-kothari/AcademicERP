package com.iiitb.academia.pojo;

public class CourseStudents {

    private Integer roll_number;
    private String full_name;
    private String grade_letter;
    private Integer grade_points;
    private Float cgpa;

    public CourseStudents() {
    }

    public CourseStudents(Integer roll_number, String full_name, String grade_letter, Integer grade_points, Float cgpa) {
        this.roll_number = roll_number;
        this.full_name = full_name;
        this.grade_letter = grade_letter;
        this.grade_points = grade_points;
        this.cgpa = cgpa;
    }

    public Integer getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(Integer roll_number) {
        this.roll_number = roll_number;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGrade_letter() {
        return grade_letter;
    }

    public void setGrade_letter(String grade_letter) {
        this.grade_letter = grade_letter;
    }

    public Integer getGrade_points() {
        return grade_points;
    }

    public void setGrade_points(Integer grade_points) {
        this.grade_points = grade_points;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }
}
