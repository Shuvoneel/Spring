package com.dawntechbd.controller;

import com.dawntechbd.dto.UserDto;
import com.dawntechbd.entity.Role;
import com.dawntechbd.entity.User;
import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping(value = "/cv/")
public class CVController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ApplicantRepo applicantRepo;
    @Autowired
    private AcademicRepo academicRepo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private JobHistoryRepo jobHistoryRepo;
    @Autowired
    private LanguageRepo languageRepo;
    @Autowired
    private ProTrainingsRepo proTrainingsRepo;
    @Autowired
    private ReferenceRepo referenceRepo;
    @Autowired
    private TechnicalRepo technicalRepo;
    @Autowired
    private ExtracurricularRepo extracurricularRepo;
    @Autowired
    private MarriageRepo marriageRepo;
    @Autowired
    private ReligionRepo religionRepo;
    @Autowired
    private BloodRepo bloodRepo;


    @GetMapping(value = "{id}")
    public String applicantProfileByApplicant(Model model, @PathVariable("id") Long id) {
        Optional<Applicant>  applicant = this.applicantRepo.findById(id);
        User user = this.userRepo.getOne(id);
        UserDto userDto = new UserDto();
        userDto.setFirstName(applicant.get().getUser().getFirstName());
        userDto.setLastName(applicant.get().getUser().getLastName());
        userDto.setFatherName(applicant.get().getUser().getFatherName());
        userDto.setMotherName(applicant.get().getUser().getMotherName());
        userDto.setGender(applicant.get().getUser().getGender());
        userDto.setBirthDate(applicant.get().getUser().getBirthDate());
        userDto.setNid(applicant.get().getUser().getNid());
        userDto.setEmail(applicant.get().getUser().getEmail());
        userDto.setMobile(applicant.get().getUser().getMobile());
        userDto.setPhoto(applicant.get().getUser().getPhoto());
        userDto.setAcademicDetailsList(this.academicRepo.findAllByUser(applicant.get().getUser()));
        userDto.setJobHistoryList(this.jobHistoryRepo.findAllByUser(applicant.get().getUser()));
        userDto.setMaritalStatus(this.marriageRepo.findAllByUser(applicant.get().getUser()));
        userDto.setReligion(this.religionRepo.findAllByUser(applicant.get().getUser()));
        userDto.setBloodGroup(this.bloodRepo.findAllByUser(applicant.get().getUser()));
        userDto.setProfessionalTrainingsList(this.proTrainingsRepo.findAllByUser(applicant.get().getUser()));
        userDto.setLanguageDetailsList(this.languageRepo.findAllByUser(applicant.get().getUser()));
        userDto.setTechnicalList(this.technicalRepo.findAllByUser(applicant.get().getUser()));
        userDto.setExtracurricularList(this.extracurricularRepo.findAllByUser(applicant.get().getUser()));
        userDto.setReferenceList(this.referenceRepo.findAllByUser(applicant.get().getUser()));



        model.addAttribute("applicantDetails", userDto);


        return "profiles/applicantProfile";
    }

    @GetMapping
    public String applicantProfile(Model model) {
//
//        User user = this.userRepo.getOne(id);
//        UserDto userDto = new UserDto();
//        userDto.setFirstName(applicant.get().getUser().getFirstName());
//        userDto.setLastName(applicant.get().getUser().getLastName());
//        userDto.setFatherName(applicant.get().getUser().getFatherName());
//        userDto.setMotherName(applicant.get().getUser().getMotherName());
//        userDto.setGender(applicant.get().getUser().getGender());
//        userDto.setBirthDate(applicant.get().getUser().getBirthDate());
//        userDto.setNid(applicant.get().getUser().getNid());
//        userDto.setEmail(applicant.get().getUser().getEmail());
//        userDto.setMobile(applicant.get().getUser().getMobile());
//        userDto.setPhoto(applicant.get().getUser().getPhoto());
//        userDto.setAcademicDetailsList(this.academicRepo.findAllByUser(applicant.get().getUser()));
//        userDto.setJobHistoryList(this.jobHistoryRepo.findAllByUser(applicant.get().getUser()));
//        userDto.setMaritalStatus(this.marriageRepo.findAllByUser(applicant.get().getUser()));
//        userDto.setReligion(this.religionRepo.findAllByUser(applicant.get().getUser()));
//        userDto.setBloodGroup(this.bloodRepo.findAllByUser(applicant.get().getUser()));
//        userDto.setProfessionalTrainingsList(this.proTrainingsRepo.findAllByUser(applicant.get().getUser()));
//        userDto.setLanguageDetailsList(this.languageRepo.findAllByUser(applicant.get().getUser()));
//        userDto.setTechnicalList(this.technicalRepo.findAllByUser(applicant.get().getUser()));
//        userDto.setExtracurricularList(this.extracurricularRepo.findAllByUser(applicant.get().getUser()));
//        userDto.setReferenceList(this.referenceRepo.findAllByUser(applicant.get().getUser()));
//
//
//
//        model.addAttribute("applicantDetails", userDto);


        return "profiles/applicantProfile";
    }
}
