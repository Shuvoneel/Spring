package com.dawntechbd.entity.languageDetails;

import javax.persistence.*;

@Entity
@Table
public class LanguageDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "bengali_id")
    private Bengali bengali;
    @ManyToOne
    @JoinColumn(name = "english_id")
    private English english;
}
