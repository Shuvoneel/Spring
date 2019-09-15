package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.jobPosting.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostingRepo extends JpaRepository<JobPosting, Long> {

}
