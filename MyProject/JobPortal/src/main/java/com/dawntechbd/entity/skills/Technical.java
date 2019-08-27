package com.dawntechbd.entity.skills;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.applicantDetails.Applicant;

import javax.persistence.*;

@Entity
@Table
public class Technical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "applicants_id")
    private Applicant applicant;

    public Technical() {
    }

    public Technical(String name, Applicant applicant) {
        this.name = name;
        this.applicant = applicant;
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

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
