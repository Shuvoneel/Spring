package com.dawntechbd.entity.applicantDetails;

import javax.persistence.*;

@Entity
@Table
public class ApplicantStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
}
