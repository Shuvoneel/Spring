package com.dawntechbd.repo;

import com.dawntechbd.entity.Role;
import com.dawntechbd.entity.addressDetails.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
    Country findByName(String name);
}
