package com.dawntechbd.entity.addressDetails;

import javax.persistence.*;

@Entity
@Table
public class AddressDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addressType;
    private String village;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private int postcode;
}
