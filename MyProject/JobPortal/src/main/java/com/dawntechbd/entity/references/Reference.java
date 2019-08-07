package com.dawntechbd.entity.references;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.applicantDetails.Applicant;

import javax.persistence.*;

@Entity
@Table
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referenceName;
    private String designation;
    private String organization;
    private String mobile;
    private String email;
    private String address;
    private String relation;
    @ManyToOne
    @JoinColumn(name = "applicantDetails_id")
    private Applicant applicant;

    public Reference() {
    }

    public Reference(String referenceName, String designation, String organization, String mobile, String email, String address, String relation, Applicant applicant) {
        this.referenceName = referenceName;
        this.designation = designation;
        this.organization = organization;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.relation = relation;
        this.applicant = applicant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
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

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
