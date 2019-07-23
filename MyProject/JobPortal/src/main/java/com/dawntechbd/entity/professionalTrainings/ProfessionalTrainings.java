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
    @JoinColumn(name = "applicantDetails_id")
    private Applicant applicant;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
