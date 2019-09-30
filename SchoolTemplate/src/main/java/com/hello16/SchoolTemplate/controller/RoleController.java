package com.hello16.SchoolTemplate.controller;


import com.hello16.SchoolTemplate.entity.Role;
import com.hello16.SchoolTemplate.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;

    // ADD Role
    @GetMapping(value = "/role/add")
    public String roleAdd(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("sucMsg", "Role Added Successfully !");
        return "roles/add";
    }

    @PostMapping(value = "/role/add")
    public String roleAdd(@Valid Role role, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "roles/add";
        } else {
            if (role != null) {
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("existMsg", "Role already exists");
                } else {
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("list", this.roleRepo.findAll());
                    model.addAttribute("sucMsg", "Role Added Successfully !");
                }
            }
        }
        return "redirect:/role/list";
    }

    // Role List
    @GetMapping(value = "/role/list")
    public String roleList(Model model) {
        model.addAttribute("list", this.roleRepo.findAll());
        return "roles/list";
    }

    // EDIT Role
    @GetMapping(value = "/role/edit/{id}")
    public String roleEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("role", this.roleRepo.getOne(id));
        model.addAttribute("sucMsg", "Successfully Updated !");
        return "roles/edit";
    }

    @PostMapping(value = "/role/edit/{id}")
    public String roleEdit(@Valid Role role, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "roles/edit";
        } else {
            if (role != null) {
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("existMsg", "Role already exists");
                    return "roles/edit";
                } else {
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("list", this.roleRepo.findAll());
                    model.addAttribute("sucMsg", "Successfully Updated !");
                }
            }
        }
        return "redirect:/role/list";
    }

    // DELETE Role
    @RequestMapping(value = "/role/del/{id}", method = RequestMethod.GET)
    public String delRole(@PathVariable("id") Long id) {
        this.roleRepo.deleteById(id);
        return "list";

    }
}
