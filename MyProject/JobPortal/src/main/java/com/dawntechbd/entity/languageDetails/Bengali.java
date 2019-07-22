package com.dawntechbd.entity.languageDetails;

import javax.persistence.*;

@Entity
@Table
public class Bengali {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String competancy;
}
