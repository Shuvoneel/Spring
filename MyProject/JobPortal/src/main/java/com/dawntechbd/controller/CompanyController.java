package com.dawntechbd.controller;


import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.jobPosting.Company;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ComCategoryRepo categoryRepo;


    @GetMapping(value = "/com/add")
    public String addCompany(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("catList", this.categoryRepo.findAll());

        return "company/add";
    }

    @PostMapping(value = "/com/add")
    public String addCompany(@Valid Company company, BindingResult bindingResult, Model model) throws IOException {

        this.companyRepo.save(company);
        model.addAttribute("company", new Company());
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("catList", this.categoryRepo.findAll());
        model.addAttribute("list", this.companyRepo.findAll());
        model.addAttribute("sucMsg", "Success !");
        return "company/list";
    }

    @GetMapping(value = "/com/list")
    public String companyList(Model model) {
        model.addAttribute("list", this.companyRepo.findAll());
        return "company/list";
    }

}
