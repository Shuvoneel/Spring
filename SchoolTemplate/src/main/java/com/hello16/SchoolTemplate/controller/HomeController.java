package com.hello16.SchoolTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {


    @GetMapping(value="/tab")
    public String viewTable() {
        return "table";
    }

    @GetMapping(value="/user")
    public String viewUser() {
        return "user";
    }

    @GetMapping(value="/dash")
    public String dashboard() {
        return "dashboard";
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping(value="/")
    public String viewIndex() {

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            /* The user is logged in :) */
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping(value="/access-denied")
    public String accessDenied() {

        return "accessDenied";
    }


}
