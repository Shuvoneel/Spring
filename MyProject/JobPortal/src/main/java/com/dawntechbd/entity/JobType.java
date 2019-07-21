package com.dawntechbd.entity;

import javax.persistence.*;

@Entity
@Table
public class JobType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
}
