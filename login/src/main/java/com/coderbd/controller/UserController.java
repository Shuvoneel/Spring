package com.coderbd.controller;

import com.coderbd.entity.Role;
import com.coderbd.entity.User;
import com.coderbd.repo.RoleRepo;
import com.coderbd.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserRepo repo;
    @Autowired
    RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/user")
    public String displayUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.roleRepo.findAll());

        return "user";
    }

    @PostMapping(value = "/user")
    public String signUp(@Valid User user, BindingResult result, Model model) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.repo.save(user);
        model.addAttribute("sucMsg", "Success !");

        return "user";
    }
}
