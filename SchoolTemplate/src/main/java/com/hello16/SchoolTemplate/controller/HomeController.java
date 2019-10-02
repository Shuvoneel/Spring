package com.hello16.SchoolTemplate.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {


    @GetMapping(value = "/")
    public String viewIndex() {

        return "index";
    }

    @GetMapping(value = "/tab")
    public String header(){
        return "table";
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

    @GetMapping(value = "/access-denied")
    public String accessDenied() {

        return "accessDenied";
    }


}
