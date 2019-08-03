package com.dawntechbd.repo;

import com.dawntechbd.entity.jobHistory.JobHistory;
import com.dawntechbd.entity.jobPosting.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobHistoryRepo extends JpaRepository<JobHistory, Long> {
}
