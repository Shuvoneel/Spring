package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.applicantDetails.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRepo extends JpaRepository<BloodGroup, Long> {
    BloodGroup findByGroupName(String groupName);
    BloodGroup findAllByUser(User user);
}
