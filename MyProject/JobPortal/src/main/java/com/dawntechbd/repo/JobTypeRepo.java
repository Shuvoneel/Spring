package com.dawntechbd.repo;

import com.dawntechbd.entity.Role;
import com.dawntechbd.entity.jobPosting.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepo extends JpaRepository<JobType, Long> {
    JobType findByType(String type);
}
