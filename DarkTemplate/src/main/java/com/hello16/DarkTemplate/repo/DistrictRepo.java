package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.addressDetails.District;
import com.hello16.DarkTemplate.entity.addressDetails.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepo extends JpaRepository<District, Long> {
    District findByName(String name);
    List<District> findAllByDivision(Division division);
//    List<District> findDistrictsByDivision_Id();
}
