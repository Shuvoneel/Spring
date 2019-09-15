package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.applicantDetails.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarriageRepo extends JpaRepository<MaritalStatus, Long> {
    MaritalStatus findByStatusType(String statusType);
    MaritalStatus findAllByUser(User user);
}
