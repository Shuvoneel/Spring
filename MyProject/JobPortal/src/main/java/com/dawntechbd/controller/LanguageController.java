package com.dawntechbd.controller;


import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.languageDetails.LanguageDetails;
import com.dawntechbd.repo.AcademicRepo;
import com.dawntechbd.repo.DegreeRepo;
import com.dawntechbd.repo.LanguageRepo;
import com.dawntechbd.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.IOException;

@Controller

@RequestMapping(value = "/lan/")
public class LanguageController {
    @Autowired
    private LanguageRepo languageRepo;
    @Autowired
    private UserRepo userRepo;


    @GetMapping(value = "add")
    public String addLanguage(Model model) {
        model.addAttribute("language", new LanguageDetails());
        model.addAttribute("userList", this.userRepo.findAll());
        return "language/add";
    }

    @PostMapping(value = "add")
    public String addLanguage(@Valid LanguageDetails language, BindingResult bindingResult, Model model) throws IOException {

        this.languageRepo.save(language);
        model.addAttribute("language", new LanguageDetails());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.languageRepo.findAll());
        model.addAttribute("sucMsg", "Success !");
        return "language/list";
    }

    @GetMapping(value = "list")
    public String languageList(Model model) {
        model.addAttribute("list", this.languageRepo.findAll());
        return "language/list";
    }

}
