package com.dawntechbd.entity.applicantDetails;

import javax.persistence.*;

@Entity
@Table
public class Religion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String religion;

    public Religion() {
    }

    public Religion(String religion) {
        this.religion = religion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }
}
