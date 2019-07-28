package com.dawntechbd.repo;

import com.dawntechbd.entity.applicantDetails.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarriageRepo extends JpaRepository<MaritalStatus, Long> {
    MaritalStatus findByStatusType(String statusType);
}
