package com.hello16.DarkTemplate.repo;


import com.hello16.DarkTemplate.entity.jobPosting.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepo extends JpaRepository<JobType, Long> {
    JobType findByType(String type);
}
