package com.dawntechbd.controller;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.jobPosting.Company;
import com.dawntechbd.entity.jobPosting.JobPosting;
import com.dawntechbd.entity.jobPosting.JobType;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class JobController {
    @Autowired
    private JobTypeRepo jobTypeRepo;
    @Autowired
    private JobPostingRepo jobPostingRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private UserRepo userRepo;

    // Add Job Posting
    @GetMapping(value = "/job/post")
    public String jobPostAdd(Model model) {
        model.addAttribute("jobPosting", new JobPosting());
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("jobTypeList", this.jobTypeRepo.findAll());
        return "jobs/postAdd";
    }

    @PostMapping(value = "/job/post")
    public String jobPostAdd(@Valid JobPosting jobPosting, BindingResult result, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        Company company = this.companyRepo.findByUser(user);
        jobPosting.setCompany(company);
        jobPosting.setUser(user);
        this.jobPostingRepo.save(jobPosting);
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("jobTypeList", this.jobTypeRepo.findAll());
        model.addAttribute("list", this.jobPostingRepo.findAll());
        model.addAttribute("jobPosting", new JobPosting());

        return "redirect:/job/listById";
    }

    @GetMapping(value = "/job/postList")
    public String jobPostList(Model model) {
        model.addAttribute("list", this.jobPostingRepo.findAll());
        return "jobs/postList";
    }


    // EDIT Job Posting
    @GetMapping(value = "/job/edit/{id}")
    public String jobPostEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("jobPosting", this.jobPostingRepo.getOne(id));
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("jobTypeList", this.jobTypeRepo.findAll());

        return "jobs/edit";
    }

    @PostMapping(value = "/job/edit/{id}")
    public String jobPostEdit(@Valid JobPosting jobPosting, BindingResult result, Model model, @PathVariable("id") Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        Company company = this.companyRepo.findByUser(user);
        jobPosting.setCompany(company);
        jobPosting.setUser(user);
        this.jobPostingRepo.save(jobPosting);
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("jobTypeList", this.jobTypeRepo.findAll());
        model.addAttribute("list", this.jobPostingRepo.findAll());
        model.addAttribute("jobPosting", new JobPosting());

        return "redirect:/job/listById";
    }

    // DELETE Posted Jobs
    @RequestMapping(value = "/job/del/{id}", method = RequestMethod.GET)
    public String deleteJobPost(@PathVariable("id") Long id) {
        this.jobPostingRepo.deleteById(id);

        return "redirect:/job/listById";
    }


    // Posted Job List By ID
    @GetMapping(value = "/job/listById")
    public String postListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.jobPostingRepo.findAllByUser(user));

        return "jobs/listById";
    }

    @GetMapping(value = "/job/home")
    public String jobHome(Model model) {
        model.addAttribute("list", this.jobPostingRepo.findAll());
        return "home";
    }


    // Job Type
    @GetMapping(value = "/job/add")
    public String JobTypeAdd(Model model) {
        model.addAttribute("jobType", new JobType());
        return "jobs/add";
    }

    @PostMapping(value = "/job/add")
    public String JobTypeAdd(@Valid JobType jobType, BindingResult result, Model model) {
        this.jobTypeRepo.save(jobType);
        model.addAttribute("jobType", new JobType());
        model.addAttribute("sucMsg", "Successfully Added !");
        model.addAttribute("list", this.jobTypeRepo.findAll());

        return "jobs/list";
    }

    @GetMapping(value = "/job/list")
    public String roleList(Model model) {
        model.addAttribute("list", this.jobTypeRepo.findAll());
        return "jobs/list";
    }

}
