package com.dawntechbd.entity.professionalTrainings;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.applicantDetails.Applicant;

import javax.persistence.*;

@Entity
@Table
public class ProfessionalTrainings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String duration;
    private String topicsCovered;
    private String institute;
    private String location;
    @ManyToOne
    @JoinColumn(name = "applicants_id")
    private Applicant applicant;

    public ProfessionalTrainings() {
    }

    public ProfessionalTrainings(String title, String duration, String topicsCovered, String institute, String location, Applicant applicant) {
        this.title = title;
        this.duration = duration;
        this.topicsCovered = topicsCovered;
        this.institute = institute;
        this.location = location;
        this.applicant = applicant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTopicsCovered() {
        return topicsCovered;
    }

    public void setTopicsCovered(String topicsCovered) {
        this.topicsCovered = topicsCovered;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

}
