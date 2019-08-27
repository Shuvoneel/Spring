package com.dawntechbd.repo;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.entity.jobHistory.JobHistory;
import com.dawntechbd.entity.professionalTrainings.ProfessionalTrainings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProTrainingsRepo extends JpaRepository<ProfessionalTrainings, Long> {
    List<ProfessionalTrainings> findAllByApplicant(Applicant applicant);
}
