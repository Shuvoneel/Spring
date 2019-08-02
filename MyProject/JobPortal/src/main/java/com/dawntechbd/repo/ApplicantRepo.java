package com.dawntechbd.repo;

import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.entity.languageDetails.LanguageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, Long> {

}
