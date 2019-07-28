package com.dawntechbd.repo;

import com.dawntechbd.entity.applicantDetails.Religion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReligionRepo extends JpaRepository<Religion, Long> {
    Religion findByReligionName(String religionName);
}
