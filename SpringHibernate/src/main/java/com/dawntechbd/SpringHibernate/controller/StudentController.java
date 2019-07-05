package com.dawntechbd.SpringHibernate.controller;


import com.dawntechbd.SpringHibernate.entity.Department;
import com.dawntechbd.SpringHibernate.entity.Student;
import com.dawntechbd.SpringHibernate.repository.CountryRepo;
import com.dawntechbd.SpringHibernate.repository.DeptRepo;
import com.dawntechbd.SpringHibernate.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo repo;
    @Autowired
    private DeptRepo deptRepo;
    @Autowired
    private CountryRepo countryRepo;

    @GetMapping(value = "/student")
    public String displayStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("list", this.repo.findAll());
        model.addAttribute("deplist", this.deptRepo.findAll());
        model.addAttribute("countrylist", this.countryRepo.findAll());

        return "student";
    }

    @PostMapping(value = "/student")
    public String save(Model model, @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Sometrhing Wrong");
        } else {
            this.repo.save(student);
            model.addAttribute("successMsg", "Data Save Successfully");
            model.addAttribute("list", this.repo.findAll());
            model.addAttribute("deplist", this.deptRepo.findAll());
            model.addAttribute("countrylist", this.countryRepo.findAll());

        }
        return "student";
    }

    @GetMapping(value = "/sbd")
    public String showStudentsByDept(Model model, @RequestParam(value = "deptId", required = false, defaultValue = "1") Long id) {
        Department department = new Department();
        department.setId(id);
        model.addAttribute("listByDept", this.repo.findAllByDepartmentOrderByName(department));
        model.addAttribute("depList", this.deptRepo.findAll());

        return "studentByDept";
    }

    @GetMapping(value = "/pro")
    public String showStudentsById(Model model, @RequestParam(value = "stuId", required = false, defaultValue = "1") Long id) {
        model.addAttribute("slist", this.repo.findAll());
        model.addAttribute("student", this.repo.getOne(id));

        return "studentProfile";
    }

    @GetMapping(value = "/sbda")
    public String showStudentsByDeptAndGender(
            Model model,
            @RequestParam(value = "depId", required = false, defaultValue = "1") Long id,
            @RequestParam(value = "gender", required = false, defaultValue = "Male") String gender) {
        Department department = new Department();
        department.setId(id);
        model.addAttribute("listByDeptAndGen", this.repo.findAllByDepartmentAndGender(department, gender));
        model.addAttribute("depList", this.deptRepo.findAll());

        return "studentByDeptAndGender";
    }

    @GetMapping(value = "/cbdg")
    public String countStudentsByDeptAndGender(
            Model model,
            @RequestParam(value = "depId", required = false, defaultValue = "1") Long id,
            @RequestParam(value = "gender", required = false, defaultValue = "Male") String gender) {
        Department department = new Department();
        department.setId(id);
        model.addAttribute("listByDeptAndGen", this.repo.findAllByDepartmentAndGender(department, gender));
        model.addAttribute("countAll", this.repo.countAllByDepartmentAndGender(department, gender));
        model.addAttribute("depList", this.deptRepo.findAll());

        return "countByDeptAndGender";
    }

    @GetMapping(value = "/sbagt")
    public String showStudentsByAgeGreaterThan(
            Model model,
            @RequestParam(value = "ageGreater", required = false, defaultValue = "20") int age) {
        model.addAttribute("listByAgeGreater", this.repo.findAllByAgeGreaterThanEqual(age));

        return "studentAgeGreaterThan";
    }

}
