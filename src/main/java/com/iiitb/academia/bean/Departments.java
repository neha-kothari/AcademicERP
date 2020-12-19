package com.iiitb.academia.bean;
import javax.persistence.*;

@Entity
@Table(name = "Departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer department_id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer capacity;

    public Departments() {
    }

    public Departments(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
