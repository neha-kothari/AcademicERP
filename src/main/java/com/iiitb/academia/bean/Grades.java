package com.iiitb.academia.bean;

import javax.persistence.*;

@Entity
@Table(name = "Grades")
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer grade_id;
    @Column(unique = true)
    private String letter_grade;
    @Column(nullable = false)
    private Integer grade_points;
    private String comment;

    public Grades() {
    }

    public Grades(String letter_grade, Integer grade_points, String comment) {
        this.letter_grade = letter_grade;
        this.grade_points = grade_points;
        this.comment = comment;
    }

    public Integer getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Integer grade_id) {
        this.grade_id = grade_id;
    }

    public String getLetter_grade() {
        return letter_grade;
    }

    public void setLetter_grade(String letter_grade) {
        this.letter_grade = letter_grade;
    }

    public Integer getGrade_points() {
        return grade_points;
    }

    public void setGrade_points(Integer grade_points) {
        this.grade_points = grade_points;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
