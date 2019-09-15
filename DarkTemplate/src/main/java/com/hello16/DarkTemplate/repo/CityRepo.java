package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.addressDetails.City;
import com.hello16.DarkTemplate.entity.addressDetails.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    City findByName(String name);
   List<City> findAllByDistrict(District district);
//    List<District> findDistrictsByDivision_Id();
}
