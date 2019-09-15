package com.dawntechbd.controller;

import com.dawntechbd.entity.User;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private RoleRepo roleRepo;
    @Autowired
    private MarriageRepo marriageRepo;
    @Autowired
    private ReligionRepo religionRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String UPLOAD_FOLDER = "src/main/resources/static/upload/";

    // Add USER
    @GetMapping(value = "/user/add")
    public String userAdd(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.roleRepo.findAll());
        model.addAttribute("marriageList", this.marriageRepo.findAll());
        model.addAttribute("religionList", this.religionRepo.findAll());
        return "users/add";
    }

    @PostMapping(value = "/user/add")
    public String userAdd(@Valid User user, BindingResult result, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        if (result.hasErrors()) {
            return "users/add";
        }
        try {
            user.setPhoto("/upload/" + file.getOriginalFilename());
            model.addAttribute("roleList", this.roleRepo.findAll());
            model.addAttribute("marriageList", this.marriageRepo.findAll());
            model.addAttribute("religionList", this.religionRepo.findAll());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepo.save(user);
            model.addAttribute("list", this.userRepo.findAll());
            model.addAttribute("user", new User());
            model.addAttribute("sucMsg", "User Saved !");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping(value = "/user/list")
    public String userList(Model model) {
        model.addAttribute("list", this.userRepo.findAll());
        return "users/list";
    }

    // USER Edit
    @GetMapping(value = "/user/edit/{id}")
    public String userEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userRepo.getOne(id));
        model.addAttribute("roleList", this.roleRepo.findAll());
        model.addAttribute("marriageList", this.marriageRepo.findAll());
        model.addAttribute("religionList", this.religionRepo.findAll());
        return "users/edit";
    }

    @PostMapping(value = "/user/edit/{id}")
    public String userEdit(@Valid User user, @PathVariable("id") Long id, BindingResult result, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        if (result.hasErrors()) {
            return "users/edit";
        }
        try {
            user.setPhoto("/upload/" + file.getOriginalFilename());
            model.addAttribute("roleList", this.roleRepo.findAll());
            model.addAttribute("marriageList", this.marriageRepo.findAll());
            model.addAttribute("religionList", this.religionRepo.findAll());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepo.save(user);
            model.addAttribute("list", this.userRepo.findAll());
            model.addAttribute("user", new User());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/user/list";
    }

    // DELETE User
    @RequestMapping(value = "/user/del/{id}", method = RequestMethod.GET)
    public String delUser(@PathVariable("id") Long id) {
        this.userRepo.deleteById(id);
        return "users/list";

    }

    // Add EMPLOYER
    @GetMapping(value = "/emp/add")
    public String empAdd(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.roleRepo.findAll());
        model.addAttribute("marriageList", this.marriageRepo.findAll());
        model.addAttribute("religionList", this.religionRepo.findAll());
        return "employers/add";
    }

    @PostMapping(value = "/emp/add")
    public String empAdd(@Valid User user, BindingResult result, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        if (result.hasErrors()) {
            return "employers/add";
        }
        try {
            user.setPhoto("/upload/" + file.getOriginalFilename());
            model.addAttribute("roleList", this.roleRepo.findAll());
            model.addAttribute("marriageList", this.marriageRepo.findAll());
            model.addAttribute("religionList", this.religionRepo.findAll());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepo.save(user);
            model.addAttribute("list", this.userRepo.findAll());
            model.addAttribute("user", new User());
            model.addAttribute("sucMsg", "User Saved !");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping(value = "/emp/list")
    public String employerList(Model model) {
        model.addAttribute("list", this.userRepo.findAll());
        return "employers/list";
    }


    // EMPLOYER Edit
    @GetMapping(value = "/emp/edit/{id}")
    public String employerEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userRepo.getOne(id));
        model.addAttribute("roleList", this.roleRepo.findAll());
        model.addAttribute("marriageList", this.marriageRepo.findAll());
        model.addAttribute("religionList", this.religionRepo.findAll());
        return "employers/edit";
    }

    @PostMapping(value = "/emp/edit/{id}")
    public String employerEdit(@Valid User user, @PathVariable("id") Long id, BindingResult result, Model model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        if (result.hasErrors()) {
            return "employers/edit";
        }
        try {
            user.setPhoto("/upload/" + file.getOriginalFilename());
            model.addAttribute("roleList", this.roleRepo.findAll());
            model.addAttribute("marriageList", this.marriageRepo.findAll());
            model.addAttribute("religionList", this.religionRepo.findAll());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepo.save(user);
            model.addAttribute("list", this.userRepo.findAll());
            model.addAttribute("user", new User());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/emp/list";
    }


    // USER List By ID
    @GetMapping(value = "/user/list/{id}")
    public String userListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.userRepo.findByUsername(user.getUsername()));
        return "users/listById";
    }

    // EMPLOYER List By ID
    @GetMapping(value = "/emp/list/{id}")
    public String empListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.userRepo.findByUsername(user.getUsername()));
        return "employers/listById";
    }
}
