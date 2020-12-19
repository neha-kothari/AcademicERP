package com.iiitb.academia.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Students")
public class Students implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;
    @Column(nullable = false,unique = true)
    private Integer roll_number;
    @Column(nullable = false)
    private String first_name;
    private String last_name;
    @Column(nullable = false, unique = true)
    private String email;
    private String photograph_path;
    @Column(nullable = false)
    private float cgpa;
    @Column(nullable = false)
    private float total_credits;
    private Integer graduation_year;

    @ManyToOne
    @JoinColumn(name="domain_id")
    private Domains domain_id;

    @ManyToOne
    @JoinColumn(name="specialisation_id")
    private Specialisation specialisation;

    @OneToMany(mappedBy = "students")
    private List<Student_Courses> student_courses;

    public Students() {
    }

    public Students(Integer roll_number, String first_name, String last_name, String email, String photograph_path, float cgpa, float total_credits, Integer graduation_year, Domains domain_id, Specialisation specialisation, List<Student_Courses> student_courses) {
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.photograph_path = photograph_path;
        this.cgpa = cgpa;
        this.total_credits = total_credits;
        this.graduation_year = graduation_year;
        this.domain_id = domain_id;
        this.specialisation = specialisation;
        this.student_courses = student_courses;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public float getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(float total_credits) {
        this.total_credits = total_credits;
    }

    public Integer getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(Integer graduation_year) {
        this.graduation_year = graduation_year;
    }

    public Domains getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(Domains domain_id) {
        this.domain_id = domain_id;
    }

    public Specialisation getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(Specialisation specialisation) {
        this.specialisation = specialisation;
    }
    @JsonbTransient
    public List<Student_Courses> getStudent_courses() {
        return student_courses;
    }

    public void setStudent_courses(List<Student_Courses> student_courses) {
        this.student_courses = student_courses;
    }
}
