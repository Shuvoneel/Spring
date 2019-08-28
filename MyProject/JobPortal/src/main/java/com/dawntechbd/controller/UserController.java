package com.dawntechbd.controller;

import com.dawntechbd.entity.User;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private MarriageRepo marriageRepo;
    @Autowired
    private ReligionRepo religionRepo;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private DivisionRepo divisionRepo;
    @Autowired
    private DistrictRepo districtRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String UPLOAD_FOLDER = "src/main/resources/static/upload/";

    // User Add
    @GetMapping(value = "add")
    public String userAdd(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.roleRepo.findAll());
        model.addAttribute("marriageList", this.marriageRepo.findAll());
        model.addAttribute("religionList", this.religionRepo.findAll());
        return "users/add";
    }

    @PostMapping(value = "add")
    public String userAdd(@Valid User user, BindingResult result, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        user.setPhoto("upload/" + file.getOriginalFilename());
        model.addAttribute("roleList", this.roleRepo.findAll());
        model.addAttribute("marriageList", this.marriageRepo.findAll());
        model.addAttribute("religionList", this.religionRepo.findAll());
        if (result.hasErrors()) {
            return "users/add";
        }
        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
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
