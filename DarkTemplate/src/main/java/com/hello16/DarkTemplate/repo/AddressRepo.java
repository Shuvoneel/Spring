package com.hello16.DarkTemplate.repo;


import com.hello16.DarkTemplate.entity.addressDetails.AddressDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressDetails, Long> {

}
