package com.hello16.DarkTemplate.entity.jobHistory;

import com.hello16.DarkTemplate.entity.User;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@Entity
@Table
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String company;
    private String location;
    private String duration;
    private String department;
    private String supervisorDetails;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public JobHistory() {
    }

    public JobHistory(String designation, String company, String location, String duration, String department, String supervisorDetails, User user) {
        this.designation = designation;
        this.company = company;
        this.location = location;
        this.duration = duration;
        this.department = department;
        this.supervisorDetails = supervisorDetails;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSupervisorDetails() {
        return supervisorDetails;
    }

    public void setSupervisorDetails(String supervisorDetails) {
        this.supervisorDetails = supervisorDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
