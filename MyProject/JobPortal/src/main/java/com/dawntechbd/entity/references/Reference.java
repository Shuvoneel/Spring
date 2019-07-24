package com.dawntechbd.entity.references;

import com.dawntechbd.entity.User;

import javax.persistence.*;

@Entity
@Table
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String designation;
    private String organization;
    private String mobile;
    private String email;
    private String address;
    private String relation;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reference() {
    }

    public Reference(String name, String designation, String organization, String mobile, String email, String address, String relation, User user) {
        this.name = name;
        this.designation = designation;
        this.organization = organization;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.relation = relation;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
