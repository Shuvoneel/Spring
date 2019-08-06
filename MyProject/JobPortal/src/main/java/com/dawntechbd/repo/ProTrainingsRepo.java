package com.dawntechbd.repo;

import com.dawntechbd.entity.professionalTrainings.ProfessionalTrainings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProTrainingsRepo extends JpaRepository<ProfessionalTrainings, Long> {

}
