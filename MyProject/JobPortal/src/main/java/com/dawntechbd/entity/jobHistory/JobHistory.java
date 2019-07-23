package com.dawntechbd.entity.jobHistory;

import com.dawntechbd.entity.User;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@Entity
@Table
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String company;
    private String location;
    private String duration;
    private String department;
    private String supervisorDetails;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
