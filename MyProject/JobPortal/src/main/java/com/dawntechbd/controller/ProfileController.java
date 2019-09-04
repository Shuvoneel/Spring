package com.dawntechbd.controller;


import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ApplicantRepo applicantRepo;
    @Autowired
    private AcademicRepo academicRepo;


    // Applicant Profile
    @GetMapping(value = "/profile/applicant")
    public String applicantProfile(Model model) {
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("applicantList", this.applicantRepo.findAll());
        return "profiles/applicant";
    }

    @GetMapping(value = "/profile/applicant/{id}")
    public String applicantProfileByApplicant(Model model, @PathVariable("id") Long id) {

        model.addAttribute("applicant", this.applicantRepo.getOne(id));

        return "profiles/applicantProfile";
    }

}
