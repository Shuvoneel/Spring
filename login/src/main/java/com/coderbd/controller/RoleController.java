package com.coderbd.controller;

import com.coderbd.entity.Role;
import com.coderbd.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo repo;

//    @RequestMapping(value = "/role-save", method = RequestMethod.GET)
//    public ModelAndView getRole() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("role", new Role());
//        modelAndView.setViewName("addrole");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/role-save", method = RequestMethod.POST)
//    public String saveRole(@Valid Role role, BindingResult result) {
//        this.repo.save(role);
//        return "addrole";
//    }

    @GetMapping(value = "/role-save")
    public String displayRole(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("roleList", this.repo.findAll());

        return "addrole";
    }

    @PostMapping(value = "/role-save")
    public String saveRole(@Valid Role role, BindingResult result, Model model) {
        this.repo.save(role);
        model.addAttribute("sucMsg", "Success !");

        return "addrole";
    }
}
