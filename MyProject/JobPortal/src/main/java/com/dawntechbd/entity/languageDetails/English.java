package com.dawntechbd.entity.languageDetails;

import javax.persistence.*;

@Entity
@Table
public class English {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String competancy;
}
