package com.dawntechbd.entity.academicDetails;

import javax.persistence.*;

@Entity
@Table
public class GroupOrDept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
