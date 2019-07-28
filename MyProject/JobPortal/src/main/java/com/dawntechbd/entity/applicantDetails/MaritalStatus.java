package com.dawntechbd.entity.applicantDetails;

import javax.persistence.*;

@Entity
@Table
public class MaritalStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String statusType;

    public MaritalStatus() {
    }

    public MaritalStatus(String statusType) {
        this.statusType = statusType;
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
}
