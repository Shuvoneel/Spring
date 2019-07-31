package com.dawntechbd.repo;

import com.dawntechbd.entity.addressDetails.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
//    List<Country> findAllByCountry(String name);
}
