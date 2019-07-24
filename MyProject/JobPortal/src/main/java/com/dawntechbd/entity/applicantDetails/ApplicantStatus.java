package com.dawntechbd.entity.applicantDetails;

import javax.persistence.*;

@Entity
@Table
public class ApplicantStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    public ApplicantStatus() {
    }

    public ApplicantStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
