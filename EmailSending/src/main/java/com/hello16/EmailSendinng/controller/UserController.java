package com.hello16.EmailSendinng.controller;

import com.hello16.EmailSendinng.entity.User;
import com.hello16.EmailSendinng.repo.UserRepo;
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

    private final String UPLOAD_FOLDER = "src/main/resources/static/upload/";

    // User Add
    @GetMapping(value = "add")
    public String userAdd(Model model) {
        model.addAttribute("user", new User());
        return "users/add";
    }

    @PostMapping(value = "add")
    public String userAdd(@Valid User user, BindingResult result, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        user.setDoc("/upload/" + file.getOriginalFilename());
        if (result.hasErrors()) {
            return "users/add";
        }
        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            this.repo.save(user);
            model.addAttribute("sucMsg", "Success !");
            model.addAttribute("list", this.repo.findAll());
            model.addAttribute("user", new User());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "users/list";
    }

    @GetMapping(value = "list")
    public String userList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "users/list";
    }


}
