package com.dawntechbd.SpringSecurity.controller;

import com.dawntechbd.SpringSecurity.entity.Student;
import com.dawntechbd.SpringSecurity.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class HomeController {
    @Autowired
    private StudentRepo repo;

    @GetMapping(value = "/insert")
    public void insertData() {
        Student student = new Student();
        student.setName(UUID.randomUUID().toString());
        student.setAge(28);
        this.repo.save(student);
    }

    @GetMapping(value = "/")
    public String displayHome(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "index";
    }

    @GetMapping(value = "/hello")
    public String displayHello() {
        return "hello";
    }


    @GetMapping(value = "/login")
    public String displayUser() {
        return "login";
    }

    @GetMapping(value = "/about")
    public String displayAbout() {
        return "about";
    }

    @GetMapping(value = "/contact")
    public String displayContact() {
        return "contact";
    }
}
