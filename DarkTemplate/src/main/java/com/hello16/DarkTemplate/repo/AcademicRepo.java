package com.hello16.DarkTemplate.repo;


import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.academicDetails.AcademicDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicRepo extends JpaRepository<AcademicDetails, Long> {
    List<AcademicDetails> findAllByUser(User user);

}
