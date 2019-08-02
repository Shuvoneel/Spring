package com.dawntechbd.entity.jobPosting;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.addressDetails.City;
import org.springframework.format.annotation.DateTimeFormat;

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
    @ManyToMany
    @JoinTable(
            name = "company_category",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date establishment;
    private String tradeLicense;
    private String CpName;
    private String CpDesignation;
    private String CpEmail;
    private String CpMobile;
    private String password;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Company() {
    }

    public Company(String companyName, String address, Set<Category> categories, Date establishment, String tradeLicense, String cpName, String cpDesignation, String cpEmail, String cpMobile, String password, User user) {
        this.companyName = companyName;
        this.address = address;
        this.categories = categories;
        this.establishment = establishment;
        this.tradeLicense = tradeLicense;
        CpName = cpName;
        CpDesignation = cpDesignation;
        CpEmail = cpEmail;
        CpMobile = cpMobile;
        this.password = password;
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
