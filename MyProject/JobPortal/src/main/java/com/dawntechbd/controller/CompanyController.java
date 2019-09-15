package com.dawntechbd.controller;


import com.dawntechbd.entity.User;
import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.jobPosting.Company;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    // ADD Company
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
        return "redirect:/com/listById";
    }

    @GetMapping(value = "/com/list")
    public String companyList(Model model) {
        model.addAttribute("list", this.companyRepo.findAll());
        return "company/list";
    }

    // COMPANY listById
    @GetMapping(value = "/com/listById")
    public String listById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.companyRepo.findAllByUser(user));
        return "company/listById";
    }

    // EDIT Company
    @GetMapping(value = "/com/edit/{id}")
    public String companyEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("company", this.companyRepo.getOne(id));
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("catList", this.categoryRepo.findAll());
        return "company/edit";
    }

    @PostMapping(value = "/com/edit/{id}")
    public String companyEdit(@Valid Company company, BindingResult result, Model model, @PathVariable("id") Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        company.setUser(user);
        this.companyRepo.save(company);
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("catList", this.categoryRepo.findAll());
        model.addAttribute("list", this.companyRepo.findAll());
        model.addAttribute("company", new Company());
        return "redirect:/com/listById";
    }

    // DELETE Company
    @RequestMapping(value = "/com/del/{id}", method = RequestMethod.GET)
    public String delUser(@PathVariable("id") Long id) {
        this.companyRepo.deleteById(id);

        return "company/list";
    }

}
