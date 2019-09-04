package com.dawntechbd.entity;

import com.sun.security.auth.UserPrincipal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String gender;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String nid;
    private String email;
    private String mobile;
    private String password;


    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;


    public User() {
    }

    public User(User user) {               // This will be used in super(user) of CustomUserDetails

        this.username = user.username;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.fatherName = user.fatherName;
        this.motherName = user.motherName;
        this.gender = user.gender;
        this.birthDate = user.birthDate;
        this.nid = user.nid;
        this.email = user.email;
        this.mobile = user.mobile;
        this.password = user.password;
        this.photo = user.photo;
        this.roles = user.roles;
    }


    public User(Long id) {
        this.id = id;
    }

    public User(String username, String firstName, String lastName, String fatherName, String motherName, String gender, Date birthDate, String nid, String email, String mobile, String password, String photo, Set<Role> roles) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.nid = nid;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.photo = photo;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
