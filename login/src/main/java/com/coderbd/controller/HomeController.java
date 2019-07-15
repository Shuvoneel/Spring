package com.coderbd.controller;

import com.coderbd.entity.User;
import com.coderbd.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserRepo repo;

    @GetMapping(value = "/sa")
    public String superAdminView() {
        return "sadmin";
    }

    @GetMapping(value = "/adm")
    public String adminView() {
        return "admin";
    }

    @GetMapping(value = "/mn")
    public String managerView() {
        return "manager";
    }

    @GetMapping(value = "/se")
    public String secureView(Model model) {
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username",auth.getName());
        User user = repo.findByUserName(auth.getName());
        model.addAttribute("name",user.getName());

        return "secure";
    }

    @GetMapping(value = "/u")
    public String userView() {
        return "user";
    }
}
