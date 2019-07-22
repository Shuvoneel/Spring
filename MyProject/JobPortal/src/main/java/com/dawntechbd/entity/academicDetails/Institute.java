package com.dawntechbd.entity.academicDetails;

import javax.persistence.*;

@Entity
@Table
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
