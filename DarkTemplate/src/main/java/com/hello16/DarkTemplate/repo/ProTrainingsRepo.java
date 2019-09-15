package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.professionalTrainings.ProfessionalTrainings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProTrainingsRepo extends JpaRepository<ProfessionalTrainings, Long> {
    List<ProfessionalTrainings> findAllByUser(User user);
}
