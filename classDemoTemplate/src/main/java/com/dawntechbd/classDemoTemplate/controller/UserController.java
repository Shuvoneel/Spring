package com.dawntechbd.classDemoTemplate.controller;

import com.dawntechbd.classDemoTemplate.entity.User;
import com.dawntechbd.classDemoTemplate.repo.RoleRepo;
import com.dawntechbd.classDemoTemplate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;


    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String UPLOAD_FOLDER = "src/main/resources/static/upload/";

    @GetMapping(value = "/signup")
    public String displayUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.roleRepo.findAll());

        return "user";
    }

    @PostMapping(value = "/signup")
    public String signup(@Valid User user, BindingResult result, @RequestParam("photo") MultipartFile photo, Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Something is Wrong !");
        }

        user.setPhotopath("/upload/" + photo.getOriginalFilename());
        byte[] bytes = photo.getBytes();
        Path path = Paths.get(UPLOAD_FOLDER + photo.getOriginalFilename());
        Files.write(path, bytes);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
        model.addAttribute("sucMsg", "Success !");

        return "user";
    }
}
