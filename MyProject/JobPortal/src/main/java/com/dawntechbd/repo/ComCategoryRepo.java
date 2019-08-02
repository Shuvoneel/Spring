package com.dawntechbd.repo;

import com.dawntechbd.entity.jobPosting.Category;
import com.dawntechbd.entity.jobPosting.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComCategoryRepo extends JpaRepository<Category, Long> {
}
