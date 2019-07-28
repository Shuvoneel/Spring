package com.dawntechbd.entity.applicantDetails;

import javax.persistence.*;

@Entity
@Table
public class Religion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String religionName;

    public Religion() {
    }

    public Religion(String religionName) {
        this.religionName = religionName;
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
}
