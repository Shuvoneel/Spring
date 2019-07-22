package com.dawntechbd.entity.applicantDetails;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.jobDetails.Company;
import com.dawntechbd.entity.jobDetails.JobDetails;

import javax.persistence.*;

@Entity
@Table
public class ApplicantDetails {
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
    private JobDetails jobDetails;
    @ManyToOne
    @JoinColumn(name = "academicDetails_id")
    private AcademicDetails academicDetails;
    @ManyToOne
    @JoinColumn(name = "applicantsStatus_id")
    private ApplicantStatus applicantStatus;
    @ManyToOne
    @JoinColumn(name = "bloodGroup_id")
    private BloodGroup bloodGroup;
    @ManyToOne
    @JoinColumn(name = "religion_id")
    private Religion religion;
}
