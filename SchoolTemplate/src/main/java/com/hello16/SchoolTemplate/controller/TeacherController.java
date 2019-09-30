package com.hello16.SchoolTemplate.controller;


import com.hello16.SchoolTemplate.entity.Teacher;
import com.hello16.SchoolTemplate.entity.User;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class TeacherController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TeacherRepo teacherRepo;

    private final String UPLOAD_FOLDER = "src/main/resources/static/upload/";


    // ADD Teacher
    @GetMapping(value = "/tea/add")
    public String addTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teachers/add";
    }

    @PostMapping(value = "/tea/add")
    public String addTeacher(@Valid Teacher teacher, BindingResult result, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "teachers/add";
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = this.userRepo.findByUsername(auth.getName());
            teacher.setUser(user);
            teacher.setPhoto("/upload/" + file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            this.teacherRepo.save(teacher);
            model.addAttribute("teacher", new Teacher());
            model.addAttribute("list", this.teacherRepo.findAll());
        }
        return "redirect:/tea/listById";
    }

    // Teacher List
    @GetMapping(value = "/tea/list")
    public String teacherList(Model model) {
        model.addAttribute("list", this.teacherRepo.findAll());

        return "teachers/list";
    }

    // Teacher ListById
    @GetMapping(value = "/tea/listById")
    public String teacherListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.teacherRepo.findByUser(user));
        return "teachers/listById";
    }

    // EDIT Teacher
    @GetMapping(value = "/tea/edit/{id}")
    public String teacherEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("teacher", this.teacherRepo.getOne(id));
        return "teachers/edit";
    }

    @PostMapping(value = "/tea/edit/{id}")
    public String teacherEdit(@Valid Teacher teacher, BindingResult result, @PathVariable("id") Long id, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "teachers/edit";
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = this.userRepo.findByUsername(auth.getName());
            teacher.setUser(user);
            teacher.setPhoto("/upload/" + file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            this.teacherRepo.save(teacher);
            model.addAttribute("teacher", new Teacher());
            model.addAttribute("list", this.teacherRepo.findAll());
        }
        return "redirect:/tea/listById";
    }

    // DELETE Teacher
    @RequestMapping(value = "/tea/del/{id}", method = RequestMethod.GET)
    public String teacherDelete(@PathVariable("id") Long id) {
        this.teacherRepo.deleteById(id);
        return "teachers/listById";
    }
}
