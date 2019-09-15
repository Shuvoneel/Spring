package com.hello16.DarkTemplate.controller;


import com.hello16.DarkTemplate.entity.addressDetails.*;
import com.hello16.DarkTemplate.repo.*;
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
    public List<Division> divisionByCountry(Model model, @RequestParam("id") Long id) {
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
