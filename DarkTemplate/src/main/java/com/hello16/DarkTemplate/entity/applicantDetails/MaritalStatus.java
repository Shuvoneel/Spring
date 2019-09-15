package com.hello16.DarkTemplate.entity.applicantDetails;

import com.hello16.DarkTemplate.entity.User;

import javax.persistence.*;

@Entity
@Table
public class MaritalStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String statusType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public MaritalStatus() {
    }

    public MaritalStatus(String statusType, User user) {
        this.statusType = statusType;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
