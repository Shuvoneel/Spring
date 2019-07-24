package com.dawntechbd.controller;

import com.dawntechbd.entity.Role;
import com.dawntechbd.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {
    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "add")
    public String roleAdd(Model model) {
        model.addAttribute("role", new Role());
        return "roles/add";
    }

    @PostMapping(value = "add")
    public String roleAdd(@Valid Role role, BindingResult result, Model model) {
        this.repo.save(role);
        model.addAttribute("role", new Role());
        model.addAttribute("sucMsg", "Success !");
        return "roles/add";
    }

    @GetMapping(value = "list")
    public String roleList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "roles/list";
    }
}
