package com.dawntechbd.entity.academicDetails;

import com.dawntechbd.entity.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class AcademicDetails {
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
}
