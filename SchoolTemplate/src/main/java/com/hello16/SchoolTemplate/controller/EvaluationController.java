package com.hello16.SchoolTemplate.controller;


import com.hello16.SchoolTemplate.entity.Evaluation;
import com.hello16.SchoolTemplate.entity.Student;
import com.hello16.SchoolTemplate.entity.User;
import com.hello16.SchoolTemplate.repo.EvaluationRepo;
import com.hello16.SchoolTemplate.repo.StudentRepo;
import com.hello16.SchoolTemplate.repo.TeacherRepo;
import com.hello16.SchoolTemplate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class EvaluationController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private EvaluationRepo evaluationRepo;


    // ADD Evaluation
    @GetMapping(value = "/evn/add")
    public String addEvaluation(Model model) {
        model.addAttribute("evaluation", new Evaluation());
        model.addAttribute("teacherList", this.teacherRepo.findAll());
        return "students/evaluation";
    }

    @PostMapping(value = "/evn/add")
    public String addEvaluation(@Valid Evaluation evaluation, BindingResult result, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "students/evaluation";
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = this.userRepo.findByUsername(auth.getName());
            evaluation.setUser(user);
            Student student = this.studentRepo.findByUser(user);
            evaluation.setStudent(student);
            this.evaluationRepo.save(evaluation);
            model.addAttribute("evaluation", new Evaluation());
            model.addAttribute("list", this.evaluationRepo.findAll());
        }
        return "redirect:/evn/listById";
    }

    // Evaluation List
    @GetMapping(value = "/evn/list")
    public String evaluationList(Model model) {
        model.addAttribute("list", this.evaluationRepo.findAll());

        return "students/evnList";
    }

    // Evaluation ListById
    @GetMapping(value = "/evn/listById")
    public String evaluationListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.evaluationRepo.findAllByUser(user));
        return "students/evnListById";
    }

    // EDIT Teacher
    @GetMapping(value = "/evn/edit/{id}")
    public String evaluationEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("evaluation", this.evaluationRepo.getOne(id));
        return "students/evnEdit";
    }

    @PostMapping(value = "/evn/edit/{id}")
    public String evaluationEdit(@Valid Evaluation evaluation, BindingResult result, @PathVariable("id") Long id, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "students/evnEdit";
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = this.userRepo.findByUsername(auth.getName());
            evaluation.setUser(user);
            Student student = this.studentRepo.findByUser(user);
            evaluation.setStudent(student);
            this.evaluationRepo.save(evaluation);
            model.addAttribute("evaluation", new Evaluation());
            model.addAttribute("list", this.evaluationRepo.findAll());
        }
        return "redirect:/evn/listById";
    }

}
