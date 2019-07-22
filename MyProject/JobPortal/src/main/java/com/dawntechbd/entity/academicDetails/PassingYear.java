package com.dawntechbd.entity.academicDetails;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class PassingYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date year;
}
