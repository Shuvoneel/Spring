package com.dawntechbd.controller;

import com.dawntechbd.entity.addressDetails.City;
import com.dawntechbd.entity.addressDetails.Country;
import com.dawntechbd.entity.addressDetails.District;
import com.dawntechbd.entity.addressDetails.Division;
import com.dawntechbd.repo.CityRepo;
import com.dawntechbd.repo.DistrictRepo;
import com.dawntechbd.repo.DivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/")
public class ChainRestController {
    @Autowired
    private DivisionRepo divisionRepo;
    @Autowired
    private DistrictRepo districtRepo;
    @Autowired
    private CityRepo cityRepo;

    @GetMapping("division")
    public List<Division> DivisionByCountry(Model model, @RequestParam("id") Long id) {
        return this.divisionRepo.findAllByCountry(new Country(id));
    }
    @GetMapping("district")
    public List<District> districtByDivision(Model model, @RequestParam("id") Long id) {
        return this.districtRepo.findAllByDivision(new Division(id));
    }
    @GetMapping("city")
    public List<City> cityByDistrict(Model model, @RequestParam("id") Long id) {
        return this.cityRepo.findAllByDistrict(new District(id));
    }
}
