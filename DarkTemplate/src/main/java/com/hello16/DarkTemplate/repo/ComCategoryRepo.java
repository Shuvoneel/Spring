package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.jobPosting.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComCategoryRepo extends JpaRepository<Category, Long> {
}
