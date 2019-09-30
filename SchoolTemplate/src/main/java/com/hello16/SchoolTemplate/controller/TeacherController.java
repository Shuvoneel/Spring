package com.hello16.SchoolTemplate.controller;


import com.hello16.SchoolTemplate.entity.Admin;
import com.hello16.SchoolTemplate.entity.Teacher;
import com.hello16.SchoolTemplate.entity.User;
import com.hello16.SchoolTemplate.repo.AdminRepo;
import com.hello16.SchoolTemplate.repo.RoleRepo;
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
    private RoleRepo roleRepo;
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

    @PostMapping(value = "/adm/add")
    public String addAdmin(@Valid Admin admin, BindingResult result, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "admins/add";
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = this.userRepo.findByUsername(auth.getName());
            admin.setUser(user);
            admin.setPhoto("/upload/" + file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            this.adminRepo.save(admin);
            model.addAttribute("admin", new Admin());
            model.addAttribute("list", this.adminRepo.findAll());
        }
        return "redirect:/adm/list/{id}";
    }

    // Admin List
    @GetMapping(value = "/adm/list")
    public String adminList(Model model) {
        model.addAttribute("list", this.adminRepo.findAll());

        return "admins/list";
    }

    // Admin ListById
    @GetMapping(value = "/adm/list/{id}")
    public String adminListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.adminRepo.findByUser(user));
        return "admins/listById";
    }

    // EDIT Admin
    @GetMapping(value = "/adm/edit/{id}")
    public String adminEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("admin", this.adminRepo.getOne(id));
        return "admins/edit";
    }

    @PostMapping(value = "/adm/edit/{id}")
    public String adminEdit(@Valid Admin admin, BindingResult result, @PathVariable("id") Long id, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "adm/edit";
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = this.userRepo.findByUsername(auth.getName());
            admin.setUser(user);
            admin.setPhoto("/upload/" + file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            this.adminRepo.save(admin);
            model.addAttribute("admin", new Admin());
            model.addAttribute("list", this.adminRepo.findAll());
        }
        return "redirect:/adm/list/{id}";
    }

    // DELETE Admin
    @RequestMapping(value = "/adm/del/{id}", method = RequestMethod.GET)
    public String adminDelete(@PathVariable("id") Long id) {
        this.userRepo.deleteById(id);
        return "admins/list";
    }
}
