package com.dawntechbd.entity;

import javax.persistence.*;
import java.util.Set;

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Set<Division> divisions;
}
