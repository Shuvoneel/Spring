package com.dawntechbd.SpringHibernate.entity;


import javax.persistence.*;

@Entity
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private int version;
    private String telType;
    private String telNumber;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

}
