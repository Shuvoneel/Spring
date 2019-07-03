package com.dawntechbd.SpringHibernate.controller;

import com.dawntechbd.SpringHibernate.entity.Department;
import com.dawntechbd.SpringHibernate.repository.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DeptController {
    @Autowired
    private DeptRepo repo;

    @GetMapping(value = "/")
    public String displayIndex(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("list", this.repo.findAll());

        return "index";
    }

    @PostMapping(value = "/")
    public String save(Model model, @Valid Department department, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Something is Wrong !");
        } else {
            this.repo.save(department);
            model.addAttribute("successMsg", "Data Saved Successfully");
            model.addAttribute("list", this.repo.findAll());
        }
        return "index";
    }
}
