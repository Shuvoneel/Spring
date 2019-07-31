package com.dawntechbd.repo;

import com.dawntechbd.entity.addressDetails.Country;
import com.dawntechbd.entity.addressDetails.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DivisionRepo extends JpaRepository<Division, Long> {
    Division findByName(String name);
   List<Division> findAllByCountry(Country country);
//    List<Division> findDivisionsByCountry_Id();
}
