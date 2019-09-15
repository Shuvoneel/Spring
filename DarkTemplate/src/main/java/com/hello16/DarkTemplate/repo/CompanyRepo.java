package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.jobPosting.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {

}
