package com.dawntechbd.entity.applicantDetails;

import javax.persistence.*;

@Entity
@Table
public class BloodGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bloodGroup;
}
