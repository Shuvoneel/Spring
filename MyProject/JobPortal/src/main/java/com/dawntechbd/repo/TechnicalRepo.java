package com.dawntechbd.repo;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.entity.jobHistory.JobHistory;
import com.dawntechbd.entity.skills.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalRepo extends JpaRepository<Technical, Long> {
    List<Technical> findAllByUser(User user);
}
