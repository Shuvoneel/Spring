package com.hello16.SchoolTemplate.controller;


import com.hello16.SchoolTemplate.entity.Student;
import com.hello16.SchoolTemplate.entity.User;
import com.hello16.SchoolTemplate.repo.StudentRepo;
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
public class StudentController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private StudentRepo studentRepo;

    private final String UPLOAD_FOLDER = "src/main/resources/static/upload/";


    // ADD Student
    @GetMapping(value = "/std/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "students/add";
    }

    @PostMapping(value = "/std/add")
    public String addStudent(@Valid Student student, BindingResult result, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "students/add";
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = this.userRepo.findByUsername(auth.getName());
            student.setUser(user);
            student.setPhoto("/upload/" + file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            this.studentRepo.save(student);
            model.addAttribute("student", new Student());
            model.addAttribute("list", this.studentRepo.findAll());
        }
        return "redirect:/std/listById";
    }

    // Student List
    @GetMapping(value = "/std/list")
    public String studentList(Model model) {
        model.addAttribute("list", this.studentRepo.findAll());

        return "students/list";
    }

    // Student ListById
    @GetMapping(value = "/std/listById")
    public String studentListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.studentRepo.findByUser(user));
        return "students/listById";
    }

    // EDIT Student
    @GetMapping(value = "/std/edit/{id}")
    public String studentEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", this.studentRepo.getOne(id));
        return "students/edit";
    }

    @PostMapping(value = "/std/edit/{id}")
    public String studentEdit(@Valid Student student, BindingResult result, @PathVariable("id") Long id, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "students/edit";
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = this.userRepo.findByUsername(auth.getName());
            student.setUser(user);
            student.setPhoto("/upload/" + file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            this.studentRepo.save(student);
            model.addAttribute("student", new Student());
            model.addAttribute("list", this.studentRepo.findAll());
        }
        return "redirect:/std/listById";
    }

    // DELETE Student
    @RequestMapping(value = "/std/del/{id}", method = RequestMethod.GET)
    public String studentDelete(@PathVariable("id") Long id) {
        this.studentRepo.deleteById(id);
        return "students/listById";
    }
}
