package com.dawntechbd.repo;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.entity.languageDetails.LanguageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, Long> {
    Iterable<Applicant> findAllByUser(User user);
    Applicant findByUser(User user);
}
