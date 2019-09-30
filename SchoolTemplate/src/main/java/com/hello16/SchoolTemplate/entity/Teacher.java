package com.hello16.SchoolTemplate.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Teacher {

    //    Fields Name start..............................................
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter Fullname")
    private String fullName;

    @NotEmpty(message = "Enter Email")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "Enter Mobile")
    @Column(unique = true)
    private String mobile;

    @NotEmpty(message = "Enter Assigned Classes")
    private String assignedClass;

    private String gender;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //    Fields Name end.........................................

    public Teacher() {
    }

    public Teacher(Long id) {
        this.id = id;
    }

    public Teacher(@NotEmpty(message = "Enter Fullname") String fullName, @NotEmpty(message = "Enter Email") String email, @NotEmpty(message = "Enter Mobile") String mobile, @NotEmpty(message = "Enter Assigned Classes") String assignedClass, String gender, String photo, User user) {
        this.fullName = fullName;
        this.email = email;
        this.mobile = mobile;
        this.assignedClass = assignedClass;
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


    public String getAssignedClass() {
        return assignedClass;
    }

    public void setAssignedClass(String assignedClass) {
        this.assignedClass = assignedClass;
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
