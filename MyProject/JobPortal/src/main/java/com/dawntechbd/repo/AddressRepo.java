package com.dawntechbd.repo;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.addressDetails.AddressDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<AddressDetails, Long> {

}
