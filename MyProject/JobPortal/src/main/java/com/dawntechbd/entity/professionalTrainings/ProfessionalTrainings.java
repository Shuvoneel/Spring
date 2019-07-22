package com.dawntechbd.entity.professionalTrainings;

import com.dawntechbd.entity.applicantDetails.ApplicantDetails;

import javax.persistence.*;

@Entity
@Table
public class ProfessionalTrainings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String duration;
    private String organization;
    @ManyToOne
    @JoinColumn(name = "applicantDetails_id")
    private ApplicantDetails applicantDetails;
}
