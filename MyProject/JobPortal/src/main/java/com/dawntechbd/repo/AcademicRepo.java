package com.dawntechbd.repo;

import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.addressDetails.AddressDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicRepo extends JpaRepository<AcademicDetails, Long> {

}
