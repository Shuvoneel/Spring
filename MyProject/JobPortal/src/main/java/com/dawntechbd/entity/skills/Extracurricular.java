package com.dawntechbd.entity.skills;

import com.dawntechbd.entity.User;

import javax.persistence.*;

@Entity
@Table
public class Extracurricular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
