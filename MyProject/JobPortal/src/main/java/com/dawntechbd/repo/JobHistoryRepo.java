package com.dawntechbd.repo;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.jobHistory.JobHistory;
import com.dawntechbd.entity.jobPosting.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobHistoryRepo extends JpaRepository<JobHistory, Long> {
    List<JobHistory> findAllByUser(User user);
}
