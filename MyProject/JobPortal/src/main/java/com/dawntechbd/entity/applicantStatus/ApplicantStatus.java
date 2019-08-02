package com.dawntechbd.entity.applicantStatus;

import com.dawntechbd.entity.User;

import javax.persistence.*;

@Entity
@Table
public class ApplicantStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ApplicantStatus() {
    }

    public ApplicantStatus(String status, User user) {
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
