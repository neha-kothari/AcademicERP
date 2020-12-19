package com.iiitb.academia.bean;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Specialisation")
public class Specialisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specialisation_id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer credits_required;

    @ManyToMany(mappedBy = "specialisations")
    private List<Courses> courses;

    public Specialisation() {
    }

    public Specialisation(String code, String name, String description, Integer year, Integer credits_required, List<Courses> courses) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.credits_required = credits_required;
        this.courses = courses;
    }

    public Integer getSpecialisation_id() {
        return specialisation_id;
    }

    public void setSpecialisation_id(Integer specialisation_id) {
        this.specialisation_id = specialisation_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCredits_required() {
        return credits_required;
    }

    public void setCredits_required(Integer credits_required) {
        this.credits_required = credits_required;
    }
    @JsonbTransient
    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
}
