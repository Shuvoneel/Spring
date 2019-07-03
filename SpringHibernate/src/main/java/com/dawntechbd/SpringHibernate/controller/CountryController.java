package com.dawntechbd.SpringHibernate.controller;

import com.dawntechbd.SpringHibernate.entity.Country;
import com.dawntechbd.SpringHibernate.entity.Department;
import com.dawntechbd.SpringHibernate.repository.CountryRepo;
import com.dawntechbd.SpringHibernate.repository.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CountryController {
    @Autowired
    private CountryRepo repo;

    @GetMapping(value = "/ct")
    public String displayIndex(Model model) {
        model.addAttribute("country", new Country());
        model.addAttribute("list", this.repo.findAll());

        return "country";
    }

    @PostMapping(value = "/ct")
    public String save(Model model, @Valid Country country, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Something is Wrong !");
        } else {
            this.repo.save(country);
            model.addAttribute("successMsg", "Data Saved Successfully");
            model.addAttribute("list", this.repo.findAll());
        }
        return "country";
    }
}
