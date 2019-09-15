package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.academicDetails.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepo extends JpaRepository<Degree, Long> {
    Degree findByName(String name);
}
