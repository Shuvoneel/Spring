package com.dawntechbd.entity.references;

import com.dawntechbd.entity.User;

import javax.persistence.*;

@Entity
@Table
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String designation;
    private String organization;
    private String mobile;
    private String email;
    private String address;
    private String relation;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
