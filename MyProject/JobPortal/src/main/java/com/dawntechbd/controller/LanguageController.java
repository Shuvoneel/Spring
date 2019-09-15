package com.dawntechbd.controller;


import com.dawntechbd.entity.User;
import com.dawntechbd.entity.academicDetails.AcademicDetails;
import com.dawntechbd.entity.languageDetails.LanguageDetails;
import com.dawntechbd.repo.AcademicRepo;
import com.dawntechbd.repo.DegreeRepo;
import com.dawntechbd.repo.LanguageRepo;
import com.dawntechbd.repo.UserRepo;
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

@RequestMapping(value = "/lan/")
public class LanguageController {
    @Autowired
    private LanguageRepo languageRepo;
    @Autowired
    private UserRepo userRepo;


    // ADD Language
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
        return "redirect:/lan/listById";
    }


    // EDIT Language
    @GetMapping(value = "edit/{id}")
    public String editLanguage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("language", this.languageRepo.getOne(id));
        model.addAttribute("userList", this.userRepo.findAll());

        return "language/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String editLanguage(@Valid LanguageDetails language, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        language.setUser(user);
        this.languageRepo.save(language);
        model.addAttribute("language", new LanguageDetails());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.languageRepo.findAll());

        return "redirect:/lan/listById";
    }

    @GetMapping(value = "list")
    public String languageList(Model model) {
        model.addAttribute("list", this.languageRepo.findAll());
        return "language/list";
    }

    // DELETE Language
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delLanguage(@PathVariable("id") Long id) {
        this.languageRepo.deleteById(id);

        return "redirect:/lan/listById";
    }

    // Language ListById
    @GetMapping(value = "listById")
    public String lanListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.languageRepo.findAllByUser(user));
        return "language/listById";
    }

}
