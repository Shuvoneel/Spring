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

    public LanguageDetails() {
    }

    public LanguageDetails(String name, String reading, String writing, String speaking, User user) {
        this.name = name;
        this.reading = reading;
        this.writing = writing;
        this.speaking = speaking;
        this.user = user;
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

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    public String getSpeaking() {
        return speaking;
    }

    public void setSpeaking(String speaking) {
        this.speaking = speaking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
