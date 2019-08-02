package com.dawntechbd.repo;

import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.languageDetails.LanguageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends JpaRepository<LanguageDetails, Long> {

}
