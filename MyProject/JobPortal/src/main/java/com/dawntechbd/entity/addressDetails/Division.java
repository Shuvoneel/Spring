package com.dawntechbd.entity.addressDetails;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
