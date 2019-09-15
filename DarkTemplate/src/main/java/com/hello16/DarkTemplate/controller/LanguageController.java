package com.hello16.DarkTemplate.controller;


import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.languageDetails.LanguageDetails;
import com.hello16.DarkTemplate.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        model.addAttribute("sucMsg", "Language Added !");
        return "language/add";
    }

    @PostMapping(value = "add")
    public String addLanguage(@Valid LanguageDetails language, BindingResult bindingResult, Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        language.setUser(user);
        this.languageRepo.save(language);
        model.addAttribute("language", new LanguageDetails());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.languageRepo.findAll());
        model.addAttribute("sucMsg", "Language Added !");
        return "language/list";
    }

    @GetMapping(value = "list")
    public String languageList(Model model) {
        model.addAttribute("list", this.languageRepo.findAll());
        return "language/list";
    }

}
