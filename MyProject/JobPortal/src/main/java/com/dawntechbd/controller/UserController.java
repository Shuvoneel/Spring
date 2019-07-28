package com.dawntechbd.controller;

import com.dawntechbd.entity.User;
import com.dawntechbd.repo.RoleRepo;
import com.dawntechbd.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserRepo repo;
    @Autowired
    private RoleRepo roleRepo;

    private final String UPLOAD_FOLDER = "src/main/resources/static/upload/";

    @GetMapping(value = "add")
    public String userAdd(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "users/add";
    }

    @PostMapping(value = "add")
    public String userAdd(@Valid User user, BindingResult result, Model model, @RequestParam("photo") MultipartFile photo) throws IOException {
        user.setPhoto("/upload/"+photo.getOriginalFilename());
        byte[] bytes = photo.getBytes();
        Path path = Paths.get(UPLOAD_FOLDER+photo.getOriginalFilename());
        Files.write(path, bytes);
        this.repo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("sucMsg", "Success !");
        return "users/add";
    }

    @GetMapping(value = "list")
    public String userList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "users/list";
    }
}
