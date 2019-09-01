package com.dawntechbd.controller;

import com.dawntechbd.entity.jobPosting.Category;
import com.dawntechbd.entity.jobPosting.JobType;
import com.dawntechbd.repo.ComCategoryRepo;
import com.dawntechbd.repo.JobTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/cat/")
public class ComCategoryController {
    @Autowired
    private ComCategoryRepo categoryRepo;

    @GetMapping(value = "add")
    public String categoryAdd(Model model) {
        model.addAttribute("category", new Category());
        return "company/addCategory";
    }

    @PostMapping(value = "add")
    public String categoryAdd(@Valid Category category, BindingResult result, Model model) {
        this.categoryRepo.save(category);
        model.addAttribute("category", new Category());
        model.addAttribute("sucMsg", "Success !");
        model.addAttribute("list", this.categoryRepo.findAll());

        return "company/catList";
    }

    @GetMapping(value = "list")
    public String roleList(Model model) {
        model.addAttribute("list", this.categoryRepo.findAll());
        return "company/catList";
    }
}
