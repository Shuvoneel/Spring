package com.hello16.SchoolTemplate.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Student {

    //    Fields Name start..............................................
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter Fullname")
    private String fullName;

    @NotEmpty(message = "Enter Father Name")
    private String fatherName;

    @NotEmpty(message = "Enter Mother Name")
    private String motherName;

    @NotEmpty(message = "Enter Class")
    private String className;

    @NotEmpty(message = "Enter Roll")
    private String roll;

    @NotEmpty(message = "Enter Email")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "Enter Mobile")
    @Column(unique = true)
    private String mobile;

    private String gender;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //    Fields Name end.........................................

    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(@NotEmpty(message = "Enter Fullname") String fullName, @NotEmpty(message = "Enter Father Name") String fatherName, @NotEmpty(message = "Enter Mother Name") String motherName, @NotEmpty(message = "Enter Class") String className, @NotEmpty(message = "Enter Roll") String roll, @NotEmpty(message = "Enter Email") String email, @NotEmpty(message = "Enter Mobile") String mobile, String gender, String photo, User user) {
        this.fullName = fullName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.className = className;
        this.roll = roll;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.photo = photo;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
