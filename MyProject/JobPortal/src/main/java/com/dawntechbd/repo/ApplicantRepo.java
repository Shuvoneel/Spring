package com.dawntechbd.repo;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.entity.jobPosting.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, Long> {
    Iterable<Applicant> findAllByUser(User user);
    Iterable<Applicant> findAllByCompany(Company company);
}
