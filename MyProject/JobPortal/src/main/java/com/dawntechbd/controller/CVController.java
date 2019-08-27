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


    // Applicant ID
    @GetMapping(value = "{id}")
    public String applicantProfileByApplicant(Model model, @PathVariable("id") Long id) {
        Applicant applicant = this.applicantRepo.getOne(id);
        User user = this.userRepo.getOne(id);
        UserDto userDto = new UserDto();
        userDto.setFirstName(applicant.getUser().getFirstName());
        userDto.setLastName(applicant.getUser().getLastName());
        userDto.setFatherName(applicant.getUser().getFatherName());
        userDto.setMotherName(applicant.getUser().getMotherName());
        userDto.setGender(applicant.getUser().getGender());
        userDto.setBirthDate(applicant.getUser().getBirthDate());
        userDto.setNid(applicant.getUser().getNid());
        userDto.setEmail(applicant.getUser().getEmail());
        userDto.setMobile(applicant.getUser().getMobile());
        userDto.setPhoto(applicant.getUser().getPhoto());
        userDto.setAcademicDetailsList(this.academicRepo.findAllByUser(applicant.getUser()));
        userDto.setJobHistoryList(this.jobHistoryRepo.findAllByUser(applicant.getUser()));
        userDto.setMaritalStatus(this.marriageRepo.findByApplicant(applicant));
        userDto.setReligion(this.religionRepo.findByApplicant(applicant));
        userDto.setBloodGroup(this.bloodRepo.findByApplicant(applicant));
        userDto.setProfessionalTrainingsList(this.proTrainingsRepo.findAllByApplicant(applicant));
        userDto.setLanguageDetailsList(this.languageRepo.findAllByUser(applicant.getUser()));
        userDto.setTechnicalList(this.technicalRepo.findAllByApplicant(applicant));
        userDto.setExtracurricularList(this.extracurricularRepo.findAllByApplicant(applicant));
        userDto.setReferenceList(this.referenceRepo.findAllByApplicant(applicant));

//         Using User

//        userDto.setFirstName(user.getFirstName());
//        userDto.setLastName(user.getLastName());
//        userDto.setFatherName(user.getFatherName());
//        userDto.setMotherName(user.getMotherName());
//        userDto.setGender(user.getGender());
//        userDto.setBirthDate(user.getBirthDate());
//        userDto.setNid(user.getNid());
//        userDto.setEmail(user.getEmail());
//        userDto.setMobile(user.getMobile());
//        userDto.setPhoto(user.getPhoto());
//        userDto.setAcademicDetailsList(this.academicRepo.findAllByUser(user));
//        userDto.setJobHistoryList(this.jobHistoryRepo.findAllByUser(user));
//        userDto.setMaritalStatus(this.marriageRepo.findByApplicant(this.applicantRepo.findByUser(user)));
//        userDto.setReligion(this.religionRepo.findByApplicant(this.applicantRepo.findByUser(user)));
//        userDto.setBloodGroup(this.bloodRepo.findByApplicant(this.applicantRepo.findByUser(user)));
//        userDto.setProfessionalTrainingsList(this.proTrainingsRepo.findAllByApplicant(this.applicantRepo.findByUser(user)));
//        userDto.setLanguageDetailsList(this.languageRepo.findAllByUser(user));
//        userDto.setTechnicalList(this.technicalRepo.findAllByApplicant(this.applicantRepo.findByUser(user)));
//        userDto.setExtracurricularList(this.extracurricularRepo.findAllByApplicant(this.applicantRepo.findByUser(user)));
//        userDto.setReferenceList(this.referenceRepo.findAllByApplicant(this.applicantRepo.findByUser(user)));




        model.addAttribute("applicantDetails", userDto);


        return "profiles/applicantProfile";
    }
}
