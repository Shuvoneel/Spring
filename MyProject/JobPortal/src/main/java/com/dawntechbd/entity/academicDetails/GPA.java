package com.dawntechbd.entity.academicDetails;

import javax.persistence.*;

@Entity
@Table
public class GPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double cgpa;

    public GPA() {
    }

    public GPA(double cgpa) {
        this.cgpa = cgpa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
