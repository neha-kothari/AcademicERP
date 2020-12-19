package com.iiitb.academia.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Courses implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private int credits;
    @Column(nullable = false)
    private Integer term;
    @Column(nullable = false,unique = true)
    private String course_code;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private Integer capacity;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employee_id;

    @OneToMany(mappedBy = "courses")
    private List<Student_Courses> student_courses;

    @ManyToMany
    @JoinTable(name = "Course_Domain", joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "domain_id")})
    private List<Domains> domains;

    @ManyToMany
    @JoinTable(name = "Course_Specialisation", joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "specialisation_id")})
    private List<Specialisation> specialisations;



    public Courses() {
    }

    public Courses(String name, String description, int credits, Integer term, String course_code, Integer year, Integer capacity, Employees employee_id, List<Student_Courses> student_courses, List<Domains> domains, List<Specialisation> specialisations) {
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.term = term;
        this.course_code = course_code;
        this.year = year;
        this.capacity = capacity;
        this.employee_id = employee_id;
        this.student_courses = student_courses;
        this.domains = domains;
        this.specialisations = specialisations;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Employees getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employees employee_id) {
        this.employee_id = employee_id;
    }
    @JsonbTransient
    public List<Student_Courses> getStudent_courses() {
        return student_courses;
    }

    public void setStudent_courses(List<Student_Courses> student_courses) {
        this.student_courses = student_courses;
    }
    @JsonbTransient
    public List<Domains> getDomains() {
        return domains;
    }

    public void setDomains(List<Domains> domains) {
        this.domains = domains;
    }
    @JsonbTransient
    public List<Specialisation> getSpecialisations() {
        return specialisations;
    }

    public void setSpecialisations(List<Specialisation> specialisations) {
        this.specialisations = specialisations;
    }
}
