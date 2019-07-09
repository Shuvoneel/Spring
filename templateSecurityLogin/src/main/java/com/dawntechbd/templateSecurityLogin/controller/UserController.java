package com.dawntechbd.templateSecurityLogin.controller;

import com.dawntechbd.templateSecurityLogin.entity.User;
import com.dawntechbd.templateSecurityLogin.repo.RoleRepo;
import com.dawntechbd.templateSecurityLogin.repo.UserRepo;
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
    public String displayUser(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("rolelist" , this.roleRepo.findAll());
        return "user";
    }
    @PostMapping(value = "signup")
    public String signUp(@Valid User user, BindingResult result,
                         @RequestParam("photo")MultipartFile photo, Model model) throws IOException{
      if(result.hasErrors()){
          model.addAttribute("errMsg","Something Wrong");
      }
        user.setPhotoPath("/upload/"+photo.getOriginalFilename());
       //for file upload
        byte[] bytes = photo.getBytes();
        Path path = Paths.get(UPLOAD_FOLDER+photo.getOriginalFilename());
        Files.write(path,bytes);
        // upload end
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
        model.addAttribute("sucMsg","Success");
        return "user";
    }

}
