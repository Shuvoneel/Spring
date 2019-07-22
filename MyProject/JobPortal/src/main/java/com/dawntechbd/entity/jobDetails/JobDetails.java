package com.dawntechbd.entity.jobDetails;

import com.dawntechbd.entity.addressDetails.Country;

import javax.persistence.*;

@Entity
@Table
public class JobDetails {
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

}
