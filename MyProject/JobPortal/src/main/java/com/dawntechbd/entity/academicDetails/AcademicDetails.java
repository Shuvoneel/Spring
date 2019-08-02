package com.dawntechbd.entity.academicDetails;

import com.dawntechbd.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class AcademicDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "degree_id")
    private Degree degree;
    private String groupOrDept;
    private String institute;
    private String gpa;
    private int passingYear;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public AcademicDetails() {
    }

    public AcademicDetails(Degree degree, String groupOrDept, String institute, String gpa, int passingYear, User user) {
        this.degree = degree;
        this.groupOrDept = groupOrDept;
        this.institute = institute;
        this.gpa = gpa;
        this.passingYear = passingYear;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getGroupOrDept() {
        return groupOrDept;
    }

    public void setGroupOrDept(String groupOrDept) {
        this.groupOrDept = groupOrDept;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public int getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(int passingYear) {
        this.passingYear = passingYear;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
