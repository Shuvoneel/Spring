package com.hello16.SchoolTemplate.controller;


import com.hello16.SchoolTemplate.entity.User;
import com.hello16.SchoolTemplate.repo.RoleRepo;
import com.hello16.SchoolTemplate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    // ADD User
    @GetMapping(value = "/user/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "users/add";
    }

    @PostMapping(value = "/user/add")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "users/add";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("list", this.userRepo.findAll());
        }
        return "redirect:/user/list";
    }

    // User List
    @GetMapping(value = "/user/list")
    public String userList(Model model) {
        model.addAttribute("list", this.userRepo.findAll());
        return "users/list";
    }

    // User ListById
    @GetMapping(value = "/user/list/{id}")
    public String userListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.userRepo.findByUsername(user.getUsername()));
        return "users/listById";
    }

    // EDIT User
    @GetMapping(value = "/user/edit/{id}")
    public String userEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userRepo.getOne(id));
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "users/edit";
    }

    @PostMapping(value = "/user/edit/{id}")
    public String userEdit(@Valid User user, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "users/edit";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("list", this.userRepo.findAll());
        }
        return "redirect:/user/list";
    }

    // DELETE Admin
    @RequestMapping(value = "/user/del/{id}", method = RequestMethod.GET)
    public String userDelete(@PathVariable("id") Long id) {
        this.userRepo.deleteById(id);
        return "users/list";
    }
}
