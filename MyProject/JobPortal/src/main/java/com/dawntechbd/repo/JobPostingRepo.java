package com.dawntechbd.repo;

import com.dawntechbd.entity.jobPosting.Company;
import com.dawntechbd.entity.jobPosting.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostingRepo extends JpaRepository<JobPosting, Long> {

}
