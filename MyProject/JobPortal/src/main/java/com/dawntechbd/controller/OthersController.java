package com.dawntechbd.controller;

import com.dawntechbd.entity.academicDetails.Degree;
import com.dawntechbd.entity.addressDetails.Country;
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

}