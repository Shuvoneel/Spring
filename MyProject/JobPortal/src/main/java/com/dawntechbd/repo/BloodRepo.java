package com.dawntechbd.repo;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.entity.applicantDetails.BloodGroup;
import com.dawntechbd.entity.applicantDetails.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRepo extends JpaRepository<BloodGroup, Long> {
    BloodGroup findByGroupName(String groupName);
    BloodGroup findAllByUser(User user);
}
