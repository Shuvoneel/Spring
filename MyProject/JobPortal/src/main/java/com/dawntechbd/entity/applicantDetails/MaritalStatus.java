package com.dawntechbd.entity.applicantDetails;

import javax.persistence.*;

@Entity
@Table
public class MaritalStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String statusType;
    @ManyToOne
    @JoinColumn(name = "applicants_id")
    private Applicant applicant;

    public MaritalStatus() {
    }

    public MaritalStatus(String statusType, Applicant applicant) {
        this.statusType = statusType;
        this.applicant = applicant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
