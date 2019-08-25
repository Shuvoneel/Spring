package com.dawntechbd.entity.applicantDetails;

import javax.persistence.*;

@Entity
@Table
public class BloodGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;
    @ManyToOne
    @JoinColumn(name = "applicants_id")
    private Applicant applicant;

    public BloodGroup() {
    }

    public BloodGroup(String groupName, Applicant applicant) {
        this.groupName = groupName;
        this.applicant = applicant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
