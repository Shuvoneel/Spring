package com.dawntechbd.entity.addressDetails;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
