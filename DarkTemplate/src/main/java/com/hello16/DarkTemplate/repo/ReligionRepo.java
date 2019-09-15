package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.applicantDetails.Religion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReligionRepo extends JpaRepository<Religion, Long> {
    Religion findByReligionName(String religionName);
    Religion findAllByUser(User user);
}
