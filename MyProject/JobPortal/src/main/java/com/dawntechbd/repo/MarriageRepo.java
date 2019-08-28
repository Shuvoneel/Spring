package com.dawntechbd.repo;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.entity.applicantDetails.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarriageRepo extends JpaRepository<MaritalStatus, Long> {
    MaritalStatus findByStatusType(String statusType);
    MaritalStatus findAllByUser(User user);
}
