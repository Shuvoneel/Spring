package com.dawntechbd.repo;

import com.dawntechbd.entity.academicDetails.Degree;
import com.dawntechbd.entity.applicantDetails.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepo extends JpaRepository<Degree, Long> {
    Degree findByName(String name);
}
