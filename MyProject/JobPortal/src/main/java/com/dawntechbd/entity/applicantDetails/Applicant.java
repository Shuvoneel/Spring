package com.dawntechbd.entity.applicantDetails;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.jobPosting.Company;
import com.dawntechbd.entity.jobPosting.JobPosting;

import javax.persistence.*;

@Entity
@Table
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPosting jobPosting;

    public Applicant() {
    }

    public Applicant(User user, Company company, JobPosting jobPosting) {
        this.user = user;
        this.company = company;
        this.jobPosting = jobPosting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }
}
