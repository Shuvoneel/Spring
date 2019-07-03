package com.dawntechbd.SpringHibernate.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private int version;

    @Column(nullable = false)
    @Size(min = 3, max = 20)
    private String firstName;

    @Column(unique = true, nullable = false)
    private String mobile;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany(mappedBy = "contact")
    private Set<ContactDetails> contactDetails;

    @OneToMany(mappedBy = "contacts")
    private Set<Hobby> hobbies;
}
