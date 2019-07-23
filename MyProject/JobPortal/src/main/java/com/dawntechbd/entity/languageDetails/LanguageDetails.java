package com.dawntechbd.entity.languageDetails;

import com.dawntechbd.entity.User;

import javax.persistence.*;

@Entity
@Table
public class LanguageDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String reading;
    private String writing;
    private String speaking;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
