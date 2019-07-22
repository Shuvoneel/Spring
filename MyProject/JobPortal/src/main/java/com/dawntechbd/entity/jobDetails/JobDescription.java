package com.dawntechbd.entity.jobDetails;

import javax.persistence.*;

@Entity
@Table
public class JobDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
}
