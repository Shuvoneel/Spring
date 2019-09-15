package com.dawntechbd.controller;


import com.dawntechbd.dto.UserDto;
import com.dawntechbd.entity.User;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


//    // Applicant Profile
//    @GetMapping(value = "/profile/applicant")
//    public String applicantProfile(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = this.userRepo.findByUsername(auth.getName());
//        model.addAttribute("applicant", this.applicantRepo.findAllByUser(user));
//        return "profiles/applicant";
//    }

    @GetMapping(value = "/profile/applicant/{id}")
    public String applicantProfileByApplicant(Model model, @PathVariable("id") Long id) {
        model.addAttribute("applicant", this.applicantRepo.getOne(id));
        return "profiles/applicantProfile";
    }

}
