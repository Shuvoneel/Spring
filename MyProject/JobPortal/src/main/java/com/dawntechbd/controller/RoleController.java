package com.dawntechbd.controller;

import com.dawntechbd.entity.Role;
import com.dawntechbd.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {
    @Autowired
    private RoleRepo repo;

    // ADD Role
    @GetMapping(value = "add")
    public String roleAdd(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("sucMsg", "Role Added Successfully !");
        return "roles/add";
    }

    @PostMapping(value = "add")
    public String roleAdd(@Valid Role role, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "role/add";
        } else {
            if (role != null) {
                Role role1 = this.repo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("existMsg", "Role already exists");
                } else {
                    this.repo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("list", this.repo.findAll());
                    model.addAttribute("sucMsg", "Role Added Successfully !");
                }
            }
        }
        return "roles/list";
    }

    @GetMapping(value = "list")
    public String roleList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "roles/list";
    }

    // EDIT Role
    @GetMapping(value = "edit/{id}")
    public String roleEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("role", this.repo.getOne(id));
        model.addAttribute("sucMsg", "Successfully Updated !");
        return "roles/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String roleEdit(@Valid Role role, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "roles/edit";
        } else {
            if (role != null) {
               Role role1 = this.repo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("existMsg", "Role already exists");
                    return "roles/edit";
                } else {
                    this.repo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("list", this.repo.findAll());
                    model.addAttribute("sucMsg", "Successfully Updated !");
                }
            }
        }
        return "redirect:/role/list";
    }

    // DELETE Role
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delRole(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "roles/list";

    }
}
