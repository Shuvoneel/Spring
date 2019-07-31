package com.dawntechbd.controller;

import com.dawntechbd.entity.academicDetails.Degree;
import com.dawntechbd.entity.addressDetails.City;
import com.dawntechbd.entity.addressDetails.Country;
import com.dawntechbd.entity.addressDetails.District;
import com.dawntechbd.entity.addressDetails.Division;
import com.dawntechbd.entity.applicantDetails.BloodGroup;
import com.dawntechbd.entity.applicantDetails.MaritalStatus;
import com.dawntechbd.entity.applicantDetails.Religion;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class OthersController {
    @Autowired
    private MarriageRepo marriageRepo;
    @Autowired
    private ReligionRepo religionRepo;
    @Autowired
    private BloodRepo bloodRepo;
    @Autowired
    private DegreeRepo degreeRepo;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private DivisionRepo divisionRepo;
    @Autowired
    private DistrictRepo districtRepo;
    @Autowired
    private CityRepo cityRepo;

    // Marital Status
    @GetMapping(value = "/ms/add")
    public String statusAdd(Model model) {
        model.addAttribute("statusType", new MaritalStatus());
        return "marriages/add";
    }

    @PostMapping(value = "/ms/add")
    public String statusAdd(@Valid MaritalStatus statusType, BindingResult result, Model model) {
        this.marriageRepo.save(statusType);
        model.addAttribute("statusType", new MaritalStatus());
        model.addAttribute("sucMsg", "Success !");
        return "marriages/add";
    }

    @GetMapping(value = "/ms/list")
    public String statusList(Model model) {
        model.addAttribute("list", this.marriageRepo.findAll());
        return "marriages/list";
    }

    // Religion
    @GetMapping(value = "/rn/add")
    public String religionAdd(Model model) {
        model.addAttribute("religion", new Religion());
        return "religions/add";
    }

    @PostMapping(value = "/rn/add")
    public String religionAdd(@Valid Religion religion, BindingResult bindingResult, Model model) {
        this.religionRepo.save(religion);
        model.addAttribute("religion", new Religion());
        model.addAttribute("sucMsg", "Success !");
        return "religions/add";
    }

    @GetMapping(value = "/rn/list")
    public String religionList(Model model) {
        model.addAttribute("list", this.religionRepo.findAll());
        return "religions/list";
    }

    //Blood Group
    @GetMapping(value = "/bg/add")
    public String bloodAdd(Model model) {
        model.addAttribute("bloodGroup", new BloodGroup());
        return "bloodGroups/add";
    }

    @PostMapping(value = "/bg/add")
    public String bloodAdd(@Valid BloodGroup bloodGroup, BindingResult bindingResult, Model model) {
        this.bloodRepo.save(bloodGroup);
        model.addAttribute("bloodGroup", new BloodGroup());
        model.addAttribute("sucMsg", "Success !");
        return "bloodGroups/add";
    }

    @GetMapping(value = "/bg/list")
    public String bloodList(Model model) {
        model.addAttribute("list", this.bloodRepo.findAll());
        return "bloodGroups/list";
    }

    //Degree
    @GetMapping(value = "/dr/add")
    public String addDegree(Model model) {
        model.addAttribute("degree", new Degree());
        return "degrees/add";
    }

    @PostMapping(value = "/dr/add")
    public String addDegree(@Valid Degree degree, BindingResult bindingResult, Model model) {
        this.degreeRepo.save(degree);
        model.addAttribute("degree", new Degree());
        model.addAttribute("sucMsg", "Success !");
        return "degrees/add";
    }

    @GetMapping(value = "/dr/list")
    public String degreeList(Model model) {
        model.addAttribute("list", this.degreeRepo.findAll());
        return "degrees/list";
    }

    //Country
    @GetMapping(value = "/ctr/add")
    public String addCountry(Model model) {
        model.addAttribute("country", new Country());
        return "address/add";
    }

    @PostMapping(value = "/ctr/add")
    public String addCountry(@Valid Country country, BindingResult bindingResult, Model model) {
        this.countryRepo.save(country);
        model.addAttribute("country", new Country());
        model.addAttribute("sucMsg", "Success !");
        return "address/add";
    }

    @GetMapping(value = "/ctr/list")
    public String countryList(Model model) {
        model.addAttribute("list", this.countryRepo.findAll());
        return "address/list";
    }

    //Division
    @GetMapping(value = "/division/add")
    public String addDivision(Model model) {
        model.addAttribute("division", new Division());
        model.addAttribute("list", this.countryRepo.findAll());
        return "address/division";
    }

    @PostMapping(value = "/division/add")
    public String addDivision(@Valid Division division, BindingResult bindingResult, Model model) {
        this.divisionRepo.save(division);
        model.addAttribute("list", this.countryRepo.findAll());
        model.addAttribute("division", new Division());
        model.addAttribute("sucMsg", "Success !");
        return "address/division";
    }

    @GetMapping(value = "/division/list")
    public String divList(Model model) {
        model.addAttribute("list", this.divisionRepo.findAll());
        return "address/divList";
    }

    //District
    @GetMapping(value = "/dist/add")
    public String addDistrict(Model model) {
        model.addAttribute("district", new District());
        model.addAttribute("list", this.countryRepo.findAll());
        model.addAttribute("list", this.divisionRepo.findAll());
        return "address/district";
    }

    @PostMapping(value = "/dist/add")
    public String addDistrict(@Valid District district, BindingResult bindingResult, Model model) {
        this.districtRepo.save(district);
        model.addAttribute("list", this.countryRepo.findAll());
        model.addAttribute("list", this.divisionRepo.findAll());
        model.addAttribute("district", new District());
        model.addAttribute("sucMsg", "Success !");
        return "address/district";
    }

    @GetMapping(value = "/dist/list")
    public String distList(Model model) {
        model.addAttribute("list", this.districtRepo.findAll());
        return "address/distList";
    }

    //City
    @GetMapping(value = "/city/add")
    public String addCity(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("list", this.countryRepo.findAll());
        model.addAttribute("list", this.divisionRepo.findAll());
        model.addAttribute("list", this.districtRepo.findAll());
        return "address/city";
    }

    @PostMapping(value = "/city/add")
    public String addCity(@Valid City city, BindingResult bindingResult, Model model) {
        this.cityRepo.save(city);
        model.addAttribute("list", this.countryRepo.findAll());
        model.addAttribute("list", this.divisionRepo.findAll());
        model.addAttribute("list", this.districtRepo.findAll());
        model.addAttribute("sucMsg", "Success !");
        model.addAttribute("city", new City());
        return "address/city";
    }

    @GetMapping(value = "/city/list")
    public String cityList(Model model) {
        model.addAttribute("list", this.cityRepo.findAll());
        return "address/cityList";
    }
}