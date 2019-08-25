package com.dawntechbd.entity.applicantDetails;

import javax.persistence.*;

@Entity
@Table
public class Religion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String religionName;
    @ManyToOne
    @JoinColumn(name = "applicants_id")
    private Applicant applicant;

    public Religion() {
    }

    public Religion(String religionName, Applicant applicant) {
        this.religionName = religionName;
        this.applicant = applicant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
