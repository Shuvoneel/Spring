package com.hello16.DarkTemplate.controller;


import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.academicDetails.*;
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
import java.io.IOException;

@Controller
public class AcademicController {
    @Autowired
    private AcademicRepo academicRepo;
    @Autowired
    private DegreeRepo degreeRepo;
    @Autowired
    private UserRepo userRepo;

    // Academic Details
    @GetMapping(value = "/edu/add")
    public String addEducation(Model model) {
        model.addAttribute("education", new AcademicDetails());
        model.addAttribute("degreeList", this.degreeRepo.findAll());
        model.addAttribute("sucMsg", "Added Successfully !");
        return "education/add";
    }

    @PostMapping(value = "/edu/add")
    public String addEducation(@Valid AcademicDetails education, BindingResult bindingResult, Model model) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        education.setUser(user);
        this.academicRepo.save(education);
        model.addAttribute("education", new AcademicDetails());
        model.addAttribute("list", this.academicRepo.findAll());
        model.addAttribute("sucMsg", "Added Successfully !");
        return "education/list";
    }

    @GetMapping(value = "/edu/list")
    public String educationList(Model model) {
        model.addAttribute("list", this.academicRepo.findAll());
        return "education/list";
    }

    // Lists By ID
    @GetMapping(value = "/edu/list/{id}")
    public String listById( Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.academicRepo.findAllByUser(user));
        return "education/listById";
    }

    //Degree
    @GetMapping(value = "/dr/add")
    public String addDegree(Model model) {
        model.addAttribute("degree", new Degree());
        model.addAttribute("sucMsg", "Added Successfully !");
        return "degrees/add";
    }

    @PostMapping(value = "/dr/add")
    public String addDegree(@Valid Degree degree, BindingResult bindingResult, Model model) {
        this.degreeRepo.save(degree);
        model.addAttribute("degree", new Degree());
        model.addAttribute("sucMsg", "Added Successfully !");
        return "degrees/add";
    }

    @GetMapping(value = "/dr/list")
    public String degreeList(Model model) {
        model.addAttribute("list", this.degreeRepo.findAll());
        return "degrees/list";
    }


}
