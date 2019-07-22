package com.dawntechbd.entity.addressDetails;

import javax.persistence.*;

@Entity
@Table
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
}
