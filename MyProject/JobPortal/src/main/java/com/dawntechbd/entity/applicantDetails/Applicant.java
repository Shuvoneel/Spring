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

}
