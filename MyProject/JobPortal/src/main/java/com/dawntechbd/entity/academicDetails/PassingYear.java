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

    public PassingYear() {
    }

    public PassingYear(Date year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }
}
