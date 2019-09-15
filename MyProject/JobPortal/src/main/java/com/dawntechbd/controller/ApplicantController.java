package com.dawntechbd.controller;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.entity.applicantDetails.BloodGroup;
import com.dawntechbd.entity.applicantDetails.MaritalStatus;
import com.dawntechbd.entity.applicantDetails.Religion;
import com.dawntechbd.entity.jobHistory.JobHistory;
import com.dawntechbd.entity.jobPosting.Company;
import com.dawntechbd.entity.professionalTrainings.ProfessionalTrainings;
import com.dawntechbd.entity.references.Reference;
import com.dawntechbd.entity.skills.Extracurricular;
import com.dawntechbd.entity.skills.Technical;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/app/listByID";
    }

    @GetMapping(value = "/app/list")
    public String applicantList(Model model) {
        model.addAttribute("list", this.applicantRepo.findAll());
        return "applicant/list";
    }

    // Applicant listById
    @GetMapping(value = "/app/listByID")
    public String applicantListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listByID", this.applicantRepo.findAllByUser(user));

        return "applicant/listByID";
    }


    // Applicant listBy CompanyId
    @GetMapping(value = "/emp/listByComId")
    public String applicantListByCompanyId(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        Company company = this.companyRepo.findByUser(user);
        model.addAttribute("listByComId", this.applicantRepo.findAllByCompany(company));

        return "employers/listByComId";
    }


    // ADD Job History
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
        return "redirect:/app/jhListById";
    }


    // EDIT Job History
    @GetMapping(value = "/app/history/edit/{id}")
    public String editJobHistory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("jobHistory", this.jobHistoryRepo.getOne(id));
        return "applicant/jhEdit";
    }

    @PostMapping(value = "/app/history/edit/{id}")
    public String editJobHistory(@Valid JobHistory jobHistory, BindingResult result, Model model, @PathVariable("id") Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        jobHistory.setUser(user);
        this.jobHistoryRepo.save(jobHistory);
        model.addAttribute("jobHistory", new JobHistory());
        model.addAttribute("list", this.jobHistoryRepo.findAll());

        return "redirect:/app/jhListById";
    }

    @GetMapping(value = "/app/jhList")
    public String historyList(Model model) {
        model.addAttribute("list", this.jobHistoryRepo.findAll());
        model.addAttribute("jobHistory", new JobHistory());
        return "applicant/JHList";
    }

    // DELETE Job History
    @RequestMapping(value = "/app/history/del/{id}", method = RequestMethod.GET)
    public String delJHistory(@PathVariable("id") Long id) {
        this.jobHistoryRepo.deleteById(id);

        return "redirect:/app/jhListById";
    }

    // Job History ListByID
    @GetMapping(value = "/app/jhListById")
    public String jhListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.jobHistoryRepo.findAllByUser(user));
        return "applicant/JHListById";
    }


    // ADD Professional Trainings
    @GetMapping(value = "/app/training")
    public String addProTraining(Model model) {
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("proTraining", new ProfessionalTrainings());
        return "applicant/proTraining";
    }

    @PostMapping(value = "/app/training")
    public String addProTraining(@Valid ProfessionalTrainings proTraining, BindingResult result, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        proTraining.setUser(user);
        this.proTrainingsRepo.save(proTraining);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.proTrainingsRepo.findAll());
        model.addAttribute("proTraining", new ProfessionalTrainings());
        return "redirect:/app/ptListById";
    }

    // EDIT Professional Trainings
    @GetMapping(value = "/app/pt/edit/{id}")
    public String editProTraining(Model model, @PathVariable("id") Long id) {
        model.addAttribute("proTraining", this.proTrainingsRepo.getOne(id));
        model.addAttribute("userList", this.userRepo.findAll());

        return "applicant/ptEdit";
    }

    @PostMapping(value = "/app/pt/edit/{id}")
    public String addProTraining(@Valid ProfessionalTrainings proTraining, BindingResult result, Model model, @PathVariable("id") Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        proTraining.setUser(user);
        this.proTrainingsRepo.save(proTraining);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.proTrainingsRepo.findAll());
        model.addAttribute("proTraining", new ProfessionalTrainings());

        return "redirect:/app/ptListById";
    }


    // DELETE Professional Trainings
    @RequestMapping(value = "/app/pt/del/{id}", method = RequestMethod.GET)
    public String delProTraining(@PathVariable("id") Long id) {
        this.proTrainingsRepo.deleteById(id);

        return "redirect:/app/ptListById";
    }

    @GetMapping(value = "/app/trainingList")
    public String trainingList(Model model) {
        model.addAttribute("list", this.proTrainingsRepo.findAll());
        model.addAttribute("proTraining", new ProfessionalTrainings());
        return "applicant/trainingList";
    }

    // Professional Trainings ListById
    @GetMapping(value = "/app/ptListById")
    public String ptListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.proTrainingsRepo.findAllByUser(user));
        return "applicant/ptListById";
    }


    // Technical Skills
    @GetMapping(value = "/app/tech")
    public String addTechnicalSkills(Model model) {
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("technical", new Technical());
        model.addAttribute("sucMsg", "Technical Skills Added !");
        return "applicant/addTech";
    }

    @PostMapping(value = "/app/tech")
    public String addTechnicalSkills(@Valid Technical technical, BindingResult result, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        technical.setUser(user);
        this.technicalRepo.save(technical);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.technicalRepo.findAll());
        model.addAttribute("technical", new Technical());
        model.addAttribute("sucMsg", "Technical Skills Added !");
        return "redirect:/app/techListById";
    }

    @GetMapping(value = "/app/techList")
    public String technicalList(Model model) {
        model.addAttribute("list", this.technicalRepo.findAll());
        model.addAttribute("technical", new Technical());
        return "applicant/techList";
    }

    // Technical Skills ListById
    @GetMapping(value = "/app/techListById")
    public String techListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.technicalRepo.findAllByUser(user));
        return "applicant/techListById";
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        extracurricular.setUser(user);
        this.extracurricularRepo.save(extracurricular);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.extracurricularRepo.findAll());
        model.addAttribute("extraActivity", new Extracurricular());
        model.addAttribute("sucMsg", "Extracurricular Activities Added !");
        return "redirect:/app/eaListById";
    }

    @GetMapping(value = "/app/exList")
    public String extraActivityList(Model model) {
        model.addAttribute("list", this.extracurricularRepo.findAll());
        model.addAttribute("extraActivity", new Extracurricular());
        return "applicant/extraActList";
    }

    // Extracurricular Activities ListById
    @GetMapping(value = "/app/eaListById")
    public String EAListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.extracurricularRepo.findAllByUser(user));
        return "applicant/extraActListById";
    }

    // ADD Reference
    @GetMapping(value = "/app/ref")
    public String addReference(Model model) {
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("reference", new Reference());
        return "applicant/addReference";
    }

    @PostMapping(value = "/app/ref")
    public String addReference(@Valid Reference reference, BindingResult result, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        reference.setUser(user);
        this.referenceRepo.save(reference);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.referenceRepo.findAll());
        model.addAttribute("reference", new Reference());
        return "redirect:/app/refListById";
    }


    // EDIT Reference
    @GetMapping(value = "/app/ref/edit/{id}")
    public String editReference(Model model, @PathVariable("id") Long id) {
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("reference", this.referenceRepo.getOne(id));

        return "applicant/refEdit";
    }

    @PostMapping(value = "/app/ref/edit/{id}")
    public String editReference(@Valid Reference reference, BindingResult result, Model model, @PathVariable("id") Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        reference.setUser(user);
        this.referenceRepo.save(reference);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("list", this.referenceRepo.findAll());
        model.addAttribute("reference", new Reference());

        return "redirect:/app/refListById";
    }

    @GetMapping(value = "/app/refList")
    public String referenceList(Model model) {
        model.addAttribute("list", this.referenceRepo.findAll());
        model.addAttribute("reference", new Reference());
        return "applicant/referenceList";
    }

    // DELETE Reference
    @RequestMapping(value = "/app/ref/del/{id}", method = RequestMethod.GET)
    public String delReference(@PathVariable("id") Long id) {
        this.referenceRepo.deleteById(id);

        return "redirect:/app/refListById";
    }


    // Reference ListById
    @GetMapping(value = "/app/refListById")
    public String refListById(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("listById", this.referenceRepo.findAllByUser(user));
        return "applicant/refListById";
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        statusType.setUser(user);
        this.marriageRepo.save(statusType);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("statusType", new MaritalStatus());
        model.addAttribute("sucMsg", "Marital Status Added !");
        return "redirect:/ms/list";
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        religion.setUser(user);
        this.religionRepo.save(religion);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("religion", new Religion());
        model.addAttribute("sucMsg", "Religion Added !");
        return "redirect:/rn/list";
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        bloodGroup.setUser(user);
        this.bloodRepo.save(bloodGroup);
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("bloodGroup", new BloodGroup());
        model.addAttribute("sucMsg", "Blood Group Added !");
        return "redirect:/bg/list";
    }

    @GetMapping(value = "/bg/list")
    public String bloodList(Model model) {
        model.addAttribute("list", this.bloodRepo.findAll());
        return "bloodGroups/list";
    }


}