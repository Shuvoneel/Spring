package com.dawntechbd.controller;

import com.dawntechbd.entity.academicDetails.Degree;
import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.entity.applicantDetails.BloodGroup;
import com.dawntechbd.entity.applicantDetails.MaritalStatus;
import com.dawntechbd.entity.applicantDetails.Religion;
import com.dawntechbd.entity.jobHistory.JobHistory;
import com.dawntechbd.entity.professionalTrainings.ProfessionalTrainings;
import com.dawntechbd.entity.references.Reference;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class ApplicantController {
    @Autowired
    private MarriageRepo marriageRepo;
    @Autowired
    private ReligionRepo religionRepo;
    @Autowired
    private BloodRepo bloodRepo;
    @Autowired
    private DegreeRepo degreeRepo;
    @Autowired
    private ApplicantRepo applicantRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JobPostingRepo jobPostingRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private JobHistoryRepo jobHistoryRepo;
    @Autowired
    private ProTrainingsRepo proTrainingsRepo;
    @Autowired
    private ReferenceRepo referenceRepo;

    // Applicant
    @GetMapping(value = "/app/add")
    public String addApplicant(Model model) {
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("comList", this.companyRepo.findAll());
        model.addAttribute("postList", this.jobPostingRepo.findAll());
        model.addAttribute("applicant", new Applicant());
        return "applicant/add";
    }

    @PostMapping(value = "/app/add")
    public String addApplicant(@Valid Applicant applicant, BindingResult result, Model model) {
        applicant.setApplyDate(new Date());
        this.applicantRepo.save(applicant);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("comList", this.companyRepo.findAll());
        model.addAttribute("postList", this.jobPostingRepo.findAll());
        model.addAttribute("list", this.applicantRepo.findAll());
        model.addAttribute("applicant", new Applicant());
        model.addAttribute("sucMsg", "Success !");
        return "applicant/list";
    }

    @GetMapping(value = "/app/list")
    public String applicantList(Model model) {
        model.addAttribute("list", this.applicantRepo.findAll());
        return "applicant/list";
    }


    // Job History
    @GetMapping(value = "/app/history")
    public String addJobHistory(Model model) {
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("jobHistory", new JobHistory());
        return "applicant/jobHistory";
    }

    @PostMapping(value = "/app/history")
    public String addJobHistory(@Valid JobHistory jobHistory, BindingResult result, Model model) {
        this.jobHistoryRepo.save(jobHistory);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.jobHistoryRepo.findAll());
        model.addAttribute("jobHistory", new JobHistory());
        model.addAttribute("sucMsg", "Success !");
        return "applicant/historyList";
    }

    @GetMapping(value = "/app/historyList")
    public String historyList(Model model) {
        model.addAttribute("list", this.jobHistoryRepo.findAll());
        model.addAttribute("jobHistory", new JobHistory());
        return "applicant/historyList";
    }


    // Professional Trainings
    @GetMapping(value = "/app/training")
    public String addProTraining(Model model) {
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("applicantList", this.applicantRepo.findAll());
        model.addAttribute("proTraining", new ProfessionalTrainings());
        return "applicant/proTraining";
    }

    @PostMapping(value = "/app/training")
    public String addProTraining(@Valid ProfessionalTrainings proTraining, BindingResult result, Model model) {
        this.proTrainingsRepo.save(proTraining);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("applicantList", this.applicantRepo.findAll());
        model.addAttribute("list", this.proTrainingsRepo.findAll());
        model.addAttribute("proTraining", new ProfessionalTrainings());
        model.addAttribute("sucMsg", "Success !");
        return "applicant/trainingList";
    }

    @GetMapping(value = "/app/trainingList")
    public String trainingList(Model model) {
        model.addAttribute("list", this.proTrainingsRepo.findAll());
        model.addAttribute("proTraining", new ProfessionalTrainings());
        return "applicant/trainingList";
    }


    // Reference
    @GetMapping(value = "/app/ref")
    public String addReference(Model model) {
        model.addAttribute("applicantList", this.applicantRepo.findAll());
        model.addAttribute("reference", new Reference());
        return "applicant/addReference";
    }

    @PostMapping(value = "/app/ref")
    public String addReference(@Valid Reference reference, BindingResult result, Model model) {
        this.referenceRepo.save(reference);
        model.addAttribute("applicantList", this.applicantRepo.findAll());
        model.addAttribute("list", this.referenceRepo.findAll());
        model.addAttribute("reference", new Reference());
        model.addAttribute("sucMsg", "Success !");
        return "applicant/referenceList";
    }

    @GetMapping(value = "/app/refList")
    public String referenceList(Model model) {
        model.addAttribute("list", this.referenceRepo.findAll());
        model.addAttribute("reference", new Reference());
        return "applicant/referenceList";
    }


    // Marital Status
    @GetMapping(value = "/ms/add")
    public String statusAdd(Model model) {
        model.addAttribute("applicantList", this.applicantRepo.findAll());
        model.addAttribute("statusType", new MaritalStatus());
        return "marriages/add";
    }

    @PostMapping(value = "/ms/add")
    public String statusAdd(@Valid MaritalStatus statusType, BindingResult result, Model model) {
        this.marriageRepo.save(statusType);
        model.addAttribute("applicantList", this.applicantRepo.findAll());
        model.addAttribute("statusType", new MaritalStatus());
        model.addAttribute("sucMsg", "Success !");
        return "marriages/add";
    }

    @GetMapping(value = "/ms/list")
    public String statusList(Model model) {
        model.addAttribute("list", this.marriageRepo.findAll());
        return "marriages/list";
    }

    // Religion
    @GetMapping(value = "/rn/add")
    public String religionAdd(Model model) {
        model.addAttribute("applicantList", this.applicantRepo.findAll());
        model.addAttribute("religion", new Religion());
        return "religions/add";
    }

    @PostMapping(value = "/rn/add")
    public String religionAdd(@Valid Religion religion, BindingResult bindingResult, Model model) {
        this.religionRepo.save(religion);
        model.addAttribute("applicantList", this.applicantRepo.findAll());
        model.addAttribute("religion", new Religion());
        model.addAttribute("sucMsg", "Success !");
        return "religions/add";
    }

    @GetMapping(value = "/rn/list")
    public String religionList(Model model) {
        model.addAttribute("list", this.religionRepo.findAll());
        return "religions/list";
    }

    //Blood Group
    @GetMapping(value = "/bg/add")
    public String bloodAdd(Model model) {
        model.addAttribute("applicantList", this.applicantRepo.findAll());
        model.addAttribute("bloodGroup", new BloodGroup());
        return "bloodGroups/add";
    }

    @PostMapping(value = "/bg/add")
    public String bloodAdd(@Valid BloodGroup bloodGroup, BindingResult bindingResult, Model model) {
        this.bloodRepo.save(bloodGroup);
        model.addAttribute("applicantList", this.applicantRepo.findAll());
        model.addAttribute("bloodGroup", new BloodGroup());
        model.addAttribute("sucMsg", "Success !");
        return "bloodGroups/add";
    }

    @GetMapping(value = "/bg/list")
    public String bloodList(Model model) {
        model.addAttribute("list", this.bloodRepo.findAll());
        return "bloodGroups/list";
    }

    //Degree
    @GetMapping(value = "/dr/add")
    public String addDegree(Model model) {
        model.addAttribute("degree", new Degree());
        return "degrees/add";
    }

    @PostMapping(value = "/dr/add")
    public String addDegree(@Valid Degree degree, BindingResult bindingResult, Model model) {
        this.degreeRepo.save(degree);
        model.addAttribute("degree", new Degree());
        model.addAttribute("sucMsg", "Success !");
        return "degrees/add";
    }

    @GetMapping(value = "/dr/list")
    public String degreeList(Model model) {
        model.addAttribute("list", this.degreeRepo.findAll());
        return "degrees/list";
    }

}