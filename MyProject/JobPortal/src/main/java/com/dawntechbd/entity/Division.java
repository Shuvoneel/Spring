package com.dawntechbd.entity;

import javax.persistence.*;
import java.util.Set;

public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private Set<City> cities;
}
