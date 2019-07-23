package com.dawntechbd.entity.jobPosting;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.addressDetails.Country;
import com.dawntechbd.entity.jobPosting.Company;
import com.dawntechbd.entity.jobPosting.JobDescription;
import com.dawntechbd.entity.jobPosting.JobType;

import javax.persistence.*;

@Entity
@Table
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private int vacancy;
    @ManyToMany
    @JoinTable(
            name = "job_description",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "description_id")
    )
    private JobDescription descriptions;
    @ManyToOne
    @JoinColumn(name = "jobType_id")
    private JobType jobType;
    private String educationalRequirements;
    private String experience;
    private String additionalRequirements;
    @ManyToMany
    @JoinTable(
            name = "job_city",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private Country location;
    private String salary;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
