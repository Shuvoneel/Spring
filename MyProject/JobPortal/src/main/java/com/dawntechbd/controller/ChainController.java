package com.dawntechbd.controller;


import com.dawntechbd.entity.addressDetails.*;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ChainController {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private DivisionRepo divisionRepo;
    @Autowired
    private DistrictRepo districtRepo;
    @Autowired
    private CityRepo cityRepo;
//    @Autowired
//    private DivisionRepo divisionRepo;
//    @Autowired
//    private DistrictRepo districtRepo;
//
//    @GetMapping(value = "/division/add")
//    public List<Division> countrySingle(Model model, @RequestParam("id") Long id) {
////        Country country = new Country();
////        country.setId(id);
//        List<Division> list = this.divisionRepo.findDivisionsByCountry_Id();
//        return list;
//    }
//
//    @GetMapping(value = "/dist/add")
//    public List<District> divisionSingle(Model model, @RequestParam("id") Long id) {
//        Division division = new Division();
//        division.setId(id);
//        List<District> list = this.districtRepo.findAllByDivision(division);
//        return list;
//    }

    //Chaining Test
    @GetMapping(value = "/chain")
    public String testChain(Model model) {
        model.addAttribute("address", new AddressDetails());
        model.addAttribute("countryList", this.countryRepo.findAll());
        model.addAttribute("divisionList", this.divisionRepo.findAll());
        model.addAttribute("districtList", this.districtRepo.findAll());
        model.addAttribute("cityList", this.cityRepo.findAll());
        return "address/chain";
    }

    @PostMapping(value = "/chain")
    public String testChain(@Valid AddressDetails address, BindingResult bindingResult, Model model) {
        this.addressRepo.save(address);
        model.addAttribute("countryList", this.countryRepo.findAll());
        model.addAttribute("divisionList", this.divisionRepo.findAll());
        model.addAttribute("districtList", this.districtRepo.findAll());
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("sucMsg", "Success !");
        model.addAttribute("address", new AddressDetails());
        return "address/chain";
    }

    @GetMapping(value = "/chainList")
    public String chainList(Model model) {
        model.addAttribute("list", this.addressRepo.findAll());
        return "address/chainList";
    }
}
