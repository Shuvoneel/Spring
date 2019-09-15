package com.hello16.DarkTemplate.controller;


import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.jobPosting.Company;
import com.hello16.DarkTemplate.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
        model.addAttribute("sucMsg", "Company Added !");

        return "company/add";
    }

    @PostMapping(value = "/com/add")
    public String addCompany(@Valid Company company, BindingResult bindingResult, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        company.setUser(user);
        this.companyRepo.save(company);
        model.addAttribute("company", new Company());
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("catList", this.categoryRepo.findAll());
        model.addAttribute("list", this.companyRepo.findAll());
        model.addAttribute("sucMsg", "Company Added !");
        return "company/list";
    }

    @GetMapping(value = "/com/list")
    public String companyList(Model model) {
        model.addAttribute("list", this.companyRepo.findAll());
        return "company/list";
    }

}
