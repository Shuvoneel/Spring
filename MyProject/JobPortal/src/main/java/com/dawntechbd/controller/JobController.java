package com.dawntechbd.controller;

import com.dawntechbd.entity.jobPosting.JobPosting;
import com.dawntechbd.entity.jobPosting.JobType;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/job/")
public class JobController {
    @Autowired
    private JobTypeRepo repo;
    @Autowired
    private JobPostingRepo jobPostingRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private UserRepo userRepo;

    // Job Posting
    @GetMapping(value = "post")
    public String jobPostAdd(Model model) {
        model.addAttribute("jobPost", new JobPosting());
        model.addAttribute("comList", this.companyRepo.findAll());
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("jobTypeList", this.repo.findAll());
        return "jobs/addPost";
    }

    @PostMapping(value = "post")
    public String jobPostAdd(@Valid JobPosting jobPost, BindingResult result, Model model) {
        this.jobPostingRepo.save(jobPost);
        model.addAttribute("jobPost", new JobPosting());
        model.addAttribute("comList", this.companyRepo.findAll());
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("jobTypeList", this.repo.findAll());
        model.addAttribute("sucMsg", "Success !");
        model.addAttribute("list", this.jobPostingRepo.findAll());

        return "jobs/postList";
    }

    @GetMapping(value = "postList")
    public String jobPostList(Model model) {
        model.addAttribute("list", this.jobPostingRepo.findAll());
        return "jobs/postList";
    }

    @GetMapping(value = "home")
    public String jobHome(Model model) {
        model.addAttribute("list", this.jobPostingRepo.findAll());
        return "home";
    }

    // Job Type
    @GetMapping(value = "add")
    public String JobTypeAdd(Model model) {
        model.addAttribute("jobType", new JobType());
        return "jobs/add";
    }

    @PostMapping(value = "add")
    public String JobTypeAdd(@Valid JobType jobType, BindingResult result, Model model) {
        this.repo.save(jobType);
        model.addAttribute("jobType", new JobType());
        model.addAttribute("sucMsg", "Success !");
        model.addAttribute("list", this.repo.findAll());

        return "jobs/list";
    }

    @GetMapping(value = "list")
    public String roleList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "jobs/list";
    }
}
