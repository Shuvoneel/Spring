package com.dawntechbd.SpringHibernate.controller;

import com.dawntechbd.SpringHibernate.entity.Country;
import com.dawntechbd.SpringHibernate.entity.Department;
import com.dawntechbd.SpringHibernate.entity.Division;
import com.dawntechbd.SpringHibernate.repository.DeptRepo;
import com.dawntechbd.SpringHibernate.repository.DivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DivisionController {
    @Autowired
    private DivisionRepo divisionRepo;

    static List<Division> divList;

    @GetMapping("/div")
    public List<Division> countrySingle(Model model,@RequestParam("id") Long id) {
        System.out.println("ID: "+id);
        List<Division> list=this.divisionRepo.findAllByCountry(new Country());
        return list;
    }
}
