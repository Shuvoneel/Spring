package com.dawntechbd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @GetMapping(value = "add")
    public String viewAdd() {
        return "users/add";
    }

    @GetMapping(value = "list")
    public String viewList() {
        return "users/list";
    }
}
