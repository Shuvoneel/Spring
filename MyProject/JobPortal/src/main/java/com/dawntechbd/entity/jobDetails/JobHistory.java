package com.dawntechbd.entity.jobDetails;

import com.dawntechbd.entity.applicantDetails.ApplicantDetails;

import javax.persistence.*;

@Entity
@Table
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String company;
    private String duration;
    private String supervisor;
}
