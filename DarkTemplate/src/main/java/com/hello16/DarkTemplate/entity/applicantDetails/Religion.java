package com.hello16.DarkTemplate.entity.applicantDetails;


import com.hello16.DarkTemplate.entity.User;

import javax.persistence.*;

@Entity
@Table
public class Religion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String religionName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Religion() {
    }

    public Religion(String religionName, User user) {
        this.religionName = religionName;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
