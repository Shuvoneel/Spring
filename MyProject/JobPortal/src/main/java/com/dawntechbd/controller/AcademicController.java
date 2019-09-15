package com.dawntechbd.controller;


import com.dawntechbd.entity.User;
import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.academicDetails.Degree;
import com.dawntechbd.entity.addressDetails.*;
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
import java.net.Authenticator;

@Controller
public class AcademicController {
    @Autowired
    private AcademicRepo academicRepo;
    @Autowired
    private DegreeRepo degreeRepo;
    @Autowired
    private UserRepo userRepo;

    // ADD Education
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
        return "redirect:/edu/listById";
    }

    @GetMapping(value = "/edu/list")
    public String educationList(Model model) {
        model.addAttribute("list", this.academicRepo.findAll());
        return "education/list";
    }

    // Lists By ID
    @GetMapping(value = "/edu/listById")
    public String listById( Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.academicRepo.findAllByUser(user));
        return "education/listById";
    }

    // EDIT Education
    @GetMapping(value = "/edu/edit/{id}")
    public String editEducation(Model model, @PathVariable("id") Long id) {
        model.addAttribute("education", this.academicRepo.getOne(id));
        model.addAttribute("degreeList", this.degreeRepo.findAll());
        return "education/edit";
    }

    @PostMapping(value = "/edu/edit/{id}")
    public String editEducation(@Valid AcademicDetails education, BindingResult bindingResult, Model model, @PathVariable("id") Long id) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        education.setUser(user);
        this.academicRepo.save(education);
        model.addAttribute("education", new AcademicDetails());
        model.addAttribute("list", this.academicRepo.findAll());
        return "redirect:/edu/listById";
    }

    // DELETE Education
    @RequestMapping(value = "/edu/del/{id}", method = RequestMethod.GET)
    public String delEducation(@PathVariable("id") Long id){
        this.academicRepo.deleteById(id);

        return "redirect:/edu/listById";
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
