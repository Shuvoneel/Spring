package com.dawntechbd.entity.addressDetails;

import com.dawntechbd.entity.User;

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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
