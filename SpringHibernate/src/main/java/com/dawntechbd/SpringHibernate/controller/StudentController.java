package com.dawntechbd.SpringHibernate.controller;


import com.dawntechbd.SpringHibernate.entity.Student;
import com.dawntechbd.SpringHibernate.repository.DeptRepo;
import com.dawntechbd.SpringHibernate.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo repo;
    @Autowired
    private DeptRepo deptRepo;

    @GetMapping(value = "/stu")
    public String displayStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("list", this.repo.findAll());
        model.addAttribute("deptlist", this.deptRepo.findAll());

        return "student";
    }

    @PostMapping(value = "/stu")
    public String save(Model model, @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Something is Wrong !");
        } else {
            this.repo.save(student);
            model.addAttribute("successMsg", "Data Saved Successfully");
            model.addAttribute("list", this.repo.findAll());
            model.addAttribute("deptlist", this.deptRepo.findAll());
        }
        return "student";
    }
}