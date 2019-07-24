package com.dawntechbd.entity.academicDetails;

import com.dawntechbd.entity.User;

import javax.persistence.*;

@Entity
@Table
public class AcademicDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "degree_id")
    private Degree degree;
    @ManyToOne
    @JoinColumn(name = "groupOrDept_id")
    private GroupOrDept groupOrDept;
    @ManyToOne
    @JoinColumn(name = "institute_id")
    private Institute institute;
    @ManyToOne
    @JoinColumn(name = "cgpa_id")
    private GPA gpa;
    @ManyToOne
    @JoinColumn(name = "passingYear_id")
    private PassingYear passingYear;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public AcademicDetails() {
    }

    public AcademicDetails(Degree degree, GroupOrDept groupOrDept, Institute institute, GPA gpa, PassingYear passingYear, User user) {
        this.degree = degree;
        this.groupOrDept = groupOrDept;
        this.institute = institute;
        this.gpa = gpa;
        this.passingYear = passingYear;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public GroupOrDept getGroupOrDept() {
        return groupOrDept;
    }

    public void setGroupOrDept(GroupOrDept groupOrDept) {
        this.groupOrDept = groupOrDept;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public GPA getGpa() {
        return gpa;
    }

    public void setGpa(GPA gpa) {
        this.gpa = gpa;
    }

    public PassingYear getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(PassingYear passingYear) {
        this.passingYear = passingYear;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
