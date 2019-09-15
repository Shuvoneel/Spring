package com.hello16.DarkTemplate.dto;


import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.academicDetails.AcademicDetails;
import com.hello16.DarkTemplate.entity.addressDetails.AddressDetails;
import com.hello16.DarkTemplate.entity.applicantDetails.BloodGroup;
import com.hello16.DarkTemplate.entity.applicantDetails.MaritalStatus;
import com.hello16.DarkTemplate.entity.applicantDetails.Religion;
import com.hello16.DarkTemplate.entity.jobHistory.JobHistory;
import com.hello16.DarkTemplate.entity.languageDetails.LanguageDetails;
import com.hello16.DarkTemplate.entity.professionalTrainings.ProfessionalTrainings;
import com.hello16.DarkTemplate.entity.references.Reference;
import com.hello16.DarkTemplate.entity.skills.Extracurricular;
import com.hello16.DarkTemplate.entity.skills.Technical;

import java.util.Date;

public class UserDto {
    private String userName;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String gender;
    private Date birthDate;
    private String nid;
    private String email;
    private String mobile;
    private String password;
    private String photo;
    private MaritalStatus maritalStatus;
    private Religion religion;
    private BloodGroup bloodGroup;

    Iterable<User> usersList;
    Iterable<AcademicDetails> academicDetailsList;
    Iterable<AddressDetails> addressDetailsList;
    Iterable<JobHistory> jobHistoryList;
    Iterable<LanguageDetails> languageDetailsList;
    Iterable<ProfessionalTrainings> professionalTrainingsList;
    Iterable<Reference> referenceList;
    Iterable<Technical> technicalList;
    Iterable<Extracurricular> extracurricularList;


    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Iterable<AcademicDetails> getAcademicDetailsList() {
        return academicDetailsList;
    }

    public void setAcademicDetailsList(Iterable<AcademicDetails> academicDetailsList) {
        this.academicDetailsList = academicDetailsList;
    }

    public Iterable<AddressDetails> getAddressDetailsList() {
        return addressDetailsList;
    }

    public void setAddressDetailsList(Iterable<AddressDetails> addressDetailsList) {
        this.addressDetailsList = addressDetailsList;
    }

    public Iterable<JobHistory> getJobHistoryList() {
        return jobHistoryList;
    }

    public void setJobHistoryList(Iterable<JobHistory> jobHistoryList) {
        this.jobHistoryList = jobHistoryList;
    }

    public Iterable<LanguageDetails> getLanguageDetailsList() {
        return languageDetailsList;
    }

    public void setLanguageDetailsList(Iterable<LanguageDetails> languageDetailsList) {
        this.languageDetailsList = languageDetailsList;
    }

    public Iterable<ProfessionalTrainings> getProfessionalTrainingsList() {
        return professionalTrainingsList;
    }

    public void setProfessionalTrainingsList(Iterable<ProfessionalTrainings> professionalTrainingsList) {
        this.professionalTrainingsList = professionalTrainingsList;
    }

    public Iterable<Reference> getReferenceList() {
        return referenceList;
    }

    public void setReferenceList(Iterable<Reference> referenceList) {
        this.referenceList = referenceList;
    }

    public Iterable<Technical> getTechnicalList() {
        return technicalList;
    }

    public void setTechnicalList(Iterable<Technical> technicalList) {
        this.technicalList = technicalList;
    }

    public Iterable<Extracurricular> getExtracurricularList() {
        return extracurricularList;
    }

    public void setExtracurricularList(Iterable<Extracurricular> extracurricularList) {
        this.extracurricularList = extracurricularList;
    }
}
