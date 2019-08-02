package com.dawntechbd.repo;

import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.jobPosting.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {

}
