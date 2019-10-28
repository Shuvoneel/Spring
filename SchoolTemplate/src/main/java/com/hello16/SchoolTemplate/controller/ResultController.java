package com.hello16.SchoolTemplate.controller;


import com.hello16.SchoolTemplate.entity.*;
import com.hello16.SchoolTemplate.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class ResultController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ResultRepo resultRepo;


    // ADD Result
    @GetMapping(value = "/res/add")
    public String addResult(Model model) {
        model.addAttribute("result", new Result());
        model.addAttribute("studentList", this.studentRepo.findAll());
        return "teachers/result";
    }

    @PostMapping(value = "/res/add")
    public String addResult(@Valid Result result, BindingResult bindingResult, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (bindingResult.hasErrors()) {
            return "teachers/result";
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = this.userRepo.findByUsername(auth.getName());
            result.setUser(user);
            Teacher teacher = this.teacherRepo.findByUser(user);
            result.setTeacher(teacher);
            this.resultRepo.save(result);
            model.addAttribute("result", new Result());
            model.addAttribute("list", this.resultRepo.findAll());
        }
        return "redirect:/res/listById";
    }

    // Result List
    @GetMapping(value = "/res/list")
    public String resultList(Model model) {
        model.addAttribute("list", this.resultRepo.findAll());

        return "teachers/resList";
    }

    // Result ListById
    @GetMapping(value = "/res/listById")
    public String resultListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.resultRepo.findAllByUser(user));
        return "teachers/resListById";
    }

    // Result ListByStudent
    @GetMapping(value = "/res/listByStd")
    public String resultListByStd(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        Student student = this.studentRepo.findByUser(user);
        model.addAttribute("listByStd", this.resultRepo.findAllByStudent(student));
        return "teachers/resByStd";
    }

    // EDIT Result
    @GetMapping(value = "/res/edit/{id}")
    public String resultEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("result", this.resultRepo.getOne(id));
        return "teachers/resEdit";
    }

    @PostMapping(value = "/res/edit/{id}")
    public String resultEdit(@Valid Result result, BindingResult bindingResult, @PathVariable("id") Long id, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (bindingResult.hasErrors()) {
            return "teachers/result";
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = this.userRepo.findByUsername(auth.getName());
            result.setUser(user);
            Teacher teacher = this.teacherRepo.findByUser(user);
            result.setTeacher(teacher);
            this.resultRepo.save(result);
            model.addAttribute("result", new Result());
            model.addAttribute("list", this.resultRepo.findAll());
        }
        return "redirect:/res/listById";
    }

}
