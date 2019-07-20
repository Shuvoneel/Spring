package com.dawntechbd.entity;

import javax.persistence.*;
import java.util.Set;

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    @ManyToMany
    @JoinTable(
            name = "job_company",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private Set<Company> companies;
    private String vacancy;
    @ManyToMany
    @JoinTable(
            name = "job_description",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "description_id")
    )
    private JobDescription descriptions;
    private String type;
    private String educationalRequirements;
    private String experience;
    private String additionalRequirements;
    private String location;
    private String salary;


}
