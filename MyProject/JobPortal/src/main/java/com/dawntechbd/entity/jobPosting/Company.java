package com.dawntechbd.entity.jobPosting;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.addressDetails.City;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    private Set<City> cities;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Company() {
    }

    public Company(String companyName, String address, String category, Date establishment, String tradeLicense, String cpName, String cpDesignation, String cpEmail, String cpMobile, String password, String logo, Set<City> cities, User user) {
        this.companyName = companyName;
        this.address = address;
        this.category = category;
        this.establishment = establishment;
        this.tradeLicense = tradeLicense;
        CpName = cpName;
        CpDesignation = cpDesignation;
        CpEmail = cpEmail;
        CpMobile = cpMobile;
        this.password = password;
        this.logo = logo;
        this.cities = cities;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Date establishment) {
        this.establishment = establishment;
    }

    public String getTradeLicense() {
        return tradeLicense;
    }

    public void setTradeLicense(String tradeLicense) {
        this.tradeLicense = tradeLicense;
    }

    public String getCpName() {
        return CpName;
    }

    public void setCpName(String cpName) {
        CpName = cpName;
    }

    public String getCpDesignation() {
        return CpDesignation;
    }

    public void setCpDesignation(String cpDesignation) {
        CpDesignation = cpDesignation;
    }

    public String getCpEmail() {
        return CpEmail;
    }

    public void setCpEmail(String cpEmail) {
        CpEmail = cpEmail;
    }

    public String getCpMobile() {
        return CpMobile;
    }

    public void setCpMobile(String cpMobile) {
        CpMobile = cpMobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
