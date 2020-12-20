package com.iiitb.academia.pojo;

public class CourseStudents {

    private Integer roll_number;
    private String first_name;
    private String last_name;
    private String grade_letter;
    private Integer grade_points;

    public CourseStudents() {
    }

    public CourseStudents(Integer roll_number, String first_name, String last_name, String grade_letter, Integer grade_points) {
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.grade_letter = grade_letter;
        this.grade_points = grade_points;
    }

    public Integer getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(Integer roll_number) {
        this.roll_number = roll_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
}
