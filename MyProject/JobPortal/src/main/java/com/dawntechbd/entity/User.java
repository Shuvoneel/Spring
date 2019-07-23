package com.dawntechbd.entity;

import com.dawntechbd.entity.applicantDetails.Religion;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String gender;
    private Date birthDate;
    private String nid;
    private String maritalStatus;
    @ManyToOne
    @JoinColumn(name = "religion_id")
    private Religion religion;
    private String email;
    private String mobile;
    private String password;
    private String photo;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
