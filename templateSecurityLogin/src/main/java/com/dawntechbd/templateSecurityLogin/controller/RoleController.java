package com.dawntechbd.templateSecurityLogin.controller;


import com.dawntechbd.templateSecurityLogin.entity.Role;
import com.dawntechbd.templateSecurityLogin.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class RoleController {
    @Autowired
    private RoleRepo repo;
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ModelAndView getRole() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role", new Role());
        modelAndView.setViewName("role");
        return modelAndView;
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public String saveRole(@Valid Role role, BindingResult bindingResult) {
        this.repo.save(role);
        return "role";
    }


}
