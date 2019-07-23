package com.dawntechbd.entity.jobPosting;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.addressDetails.City;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String address;
    private String category;
    private Date establishment;
    private String tradeLicense;
    private String CpName;
    private String CpDesignation;
    private String CpEmail;
    private String CpMobile;
    private String password;
    private String logo;
    @ManyToMany
    @JoinTable(
            name = "company_city",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private City city;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
