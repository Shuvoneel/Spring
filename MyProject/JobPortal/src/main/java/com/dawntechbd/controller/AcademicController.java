package com.dawntechbd.controller;


import com.dawntechbd.entity.User;
import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.addressDetails.*;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.net.Authenticator;

@Controller
public class AcademicController {
    @Autowired
    private AcademicRepo academicRepo;
    @Autowired
    private DegreeRepo degreeRepo;
    @Autowired
    private UserRepo userRepo;


    @GetMapping(value = "/edu/add")
    public String addEducation(Model model) {
        model.addAttribute("education", new AcademicDetails());
        model.addAttribute("degreeList", this.degreeRepo.findAll());
             return "education/add";
    }

    @PostMapping(value = "/edu/add")
    public String addEducation(@Valid AcademicDetails education, BindingResult bindingResult, Model model) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        education.setUser(user);
        this.academicRepo.save(education);
        model.addAttribute("education", new AcademicDetails());
        model.addAttribute("degreeList", this.degreeRepo.findAll());
        model.addAttribute("list", this.academicRepo.findAll());
        model.addAttribute("sucMsg", "Success !");
        return "education/list";
    }

    @GetMapping(value = "/edu/list")
    public String educationList(Model model) {
        model.addAttribute("list", this.academicRepo.findAll());
        return "education/list";
    }

}
