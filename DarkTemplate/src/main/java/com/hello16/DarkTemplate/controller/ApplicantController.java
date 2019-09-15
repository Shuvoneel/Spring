package com.hello16.DarkTemplate.controller;

import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.applicantDetails.*;
import com.hello16.DarkTemplate.entity.jobHistory.JobHistory;
import com.hello16.DarkTemplate.entity.professionalTrainings.ProfessionalTrainings;
import com.hello16.DarkTemplate.entity.references.Reference;
import com.hello16.DarkTemplate.entity.skills.*;
import com.hello16.DarkTemplate.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    private TechnicalRepo technicalRepo;
    @Autowired
    private ExtracurricularRepo extracurricularRepo;

    // Applicant
    @GetMapping(value = "/app/add")
    public String addApplicant(Model model) {
        model.addAttribute("comList", this.companyRepo.findAll());
        model.addAttribute("postList", this.jobPostingRepo.findAll());
        model.addAttribute("applicant", new Applicant());
        model.addAttribute("sucMsg", "Application Successful !");
        return "applicant/add";
    }

    @PostMapping(value = "/app/add")
    public String addApplicant(@Valid Applicant applicant, BindingResult result, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        applicant.setUser(user);
        applicant.setApplyDate(new Date());
        this.applicantRepo.save(applicant);
        model.addAttribute("comList", this.companyRepo.findAll());
        model.addAttribute("postList", this.jobPostingRepo.findAll());
        model.addAttribute("list", this.applicantRepo.findAll());
        model.addAttribute("applicant", new Applicant());
        model.addAttribute("sucMsg", "Application Successful !");
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
        model.addAttribute("jobHistory", new JobHistory());
        model.addAttribute("sucMsg", "Job History Added !");
        return "applicant/jobHistory";
    }

    @PostMapping(value = "/app/history")
    public String addJobHistory(@Valid JobHistory jobHistory, BindingResult result, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        jobHistory.setUser(user);
        this.jobHistoryRepo.save(jobHistory);
        model.addAttribute("jobHistory", new JobHistory());
        model.addAttribute("list", this.jobHistoryRepo.findAll());
        model.addAttribute("sucMsg", "Job History Added !");
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
        model.addAttribute("proTraining", new ProfessionalTrainings());
        model.addAttribute("sucMsg", "Professional Trainings Added !");
        return "applicant/proTraining";
    }

    @PostMapping(value = "/app/training")
    public String addProTraining(@Valid ProfessionalTrainings proTraining, BindingResult result, Model model) {
        Authentication auth =SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        proTraining.setUser(user);
        this.proTrainingsRepo.save(proTraining);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.proTrainingsRepo.findAll());
        model.addAttribute("proTraining", new ProfessionalTrainings());
        model.addAttribute("sucMsg", "Professional Trainings Added !");
        return "applicant/trainingList";
    }

    @GetMapping(value = "/app/trainingList")
    public String trainingList(Model model) {
        model.addAttribute("list", this.proTrainingsRepo.findAll());
        model.addAttribute("proTraining", new ProfessionalTrainings());
        return "applicant/trainingList";
    }


    // Technical Skills
    @GetMapping(value = "/skills/add")
    public String addTechnicalSkills(Model model) {
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("technical", new Technical());
        model.addAttribute("sucMsg", "Technical Skills Added !");
        return "skills/add";
    }

    @PostMapping(value = "/skills/add")
    public String addTechnicalSkills(@Valid Technical technical, BindingResult result, Model model) {
        Authentication auth =SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        technical.setUser(user);
        this.technicalRepo.save(technical);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.technicalRepo.findAll());
        model.addAttribute("technical", new Technical());
        model.addAttribute("sucMsg", "Technical Skills Added !");
        return "skills/list";
    }

    @GetMapping(value = "/skills/list")
    public String technicalList(Model model) {
        model.addAttribute("list", this.technicalRepo.findAll());
        model.addAttribute("technical", new Technical());
        return "skills/list";
    }


    // Extracurricular Activities
    @GetMapping(value = "/app/addEx")
    public String addExtraActivity(Model model) {
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("extraActivity", new Extracurricular());
        model.addAttribute("sucMsg", "Extracurricular Activities Added !");
        return "applicant/addExtraAct";
    }

    @PostMapping(value = "/app/addEx")
    public String addExtraActivity(@Valid Extracurricular extracurricular, BindingResult result, Model model) {
        Authentication auth =SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        extracurricular.setUser(user);
        this.extracurricularRepo.save(extracurricular);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.extracurricularRepo.findAll());
        model.addAttribute("extraActivity", new Extracurricular());
        model.addAttribute("sucMsg", "Extracurricular Activities Added !");
        return "applicant/extraActList";
    }

    @GetMapping(value = "/app/exList")
    public String extraActivityList(Model model) {
        model.addAttribute("list", this.extracurricularRepo.findAll());
        model.addAttribute("extraActivity", new Extracurricular());
        return "applicant/extraActList";
    }


    // Reference
    @GetMapping(value = "/app/ref")
    public String addReference(Model model) {
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("reference", new Reference());
        model.addAttribute("sucMsg", "Reference Added !");
        return "applicant/addReference";
    }

    @PostMapping(value = "/app/ref")
    public String addReference(@Valid Reference reference, BindingResult result, Model model) {
        Authentication auth =SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        reference.setUser(user);
        this.referenceRepo.save(reference);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.referenceRepo.findAll());
        model.addAttribute("reference", new Reference());
        model.addAttribute("sucMsg", "Reference Added !");
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
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("statusType", new MaritalStatus());
        model.addAttribute("sucMsg", "Marital Status Added !");
        return "marriages/add";
    }

    @PostMapping(value = "/ms/add")
    public String statusAdd(@Valid MaritalStatus statusType, BindingResult result, Model model) {
        Authentication auth =SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        statusType.setUser(user);
        this.marriageRepo.save(statusType);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("statusType", new MaritalStatus());
        model.addAttribute("sucMsg", "Marital Status Added !");
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
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("religion", new Religion());
        model.addAttribute("sucMsg", "Religion Added !");
        return "religions/add";
    }

    @PostMapping(value = "/rn/add")
    public String religionAdd(@Valid Religion religion, BindingResult bindingResult, Model model) {
        Authentication auth =SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        religion.setUser(user);
        this.religionRepo.save(religion);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("religion", new Religion());
        model.addAttribute("sucMsg", "Religion Added !");
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
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("bloodGroup", new BloodGroup());
        model.addAttribute("sucMsg", "Blood Group Added !");
        return "bloodGroups/add";
    }

    @PostMapping(value = "/bg/add")
    public String bloodAdd(@Valid BloodGroup bloodGroup, BindingResult bindingResult, Model model) {
        Authentication auth =SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        bloodGroup.setUser(user);
        this.bloodRepo.save(bloodGroup);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("bloodGroup", new BloodGroup());
        model.addAttribute("sucMsg", "Blood Group Added !");
        return "bloodGroups/add";
    }

    @GetMapping(value = "/bg/list")
    public String bloodList(Model model) {
        model.addAttribute("list", this.bloodRepo.findAll());
        return "bloodGroups/list";
    }


}