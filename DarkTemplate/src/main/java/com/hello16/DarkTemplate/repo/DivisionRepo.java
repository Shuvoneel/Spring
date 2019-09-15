package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.addressDetails.Country;
import com.hello16.DarkTemplate.entity.addressDetails.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DivisionRepo extends JpaRepository<Division, Long> {
    Division findByName(String name);
   List<Division> findAllByCountry(Country country);
//    List<Division> findDivisionsByCountry_Id();
}
