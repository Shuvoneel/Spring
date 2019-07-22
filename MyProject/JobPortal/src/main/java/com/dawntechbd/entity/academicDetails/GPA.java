package com.dawntechbd.entity.academicDetails;

import javax.persistence.*;

@Entity
@Table
public class GPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double cgpa;
}
