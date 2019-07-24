package com.dawntechbd.entity.jobPosting;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.addressDetails.Country;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private int vacancy;
    @ManyToMany
    @JoinTable(
            name = "job_descriptions",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "descriptions_id")
    )
    private Set<JobDescription> jobDescriptions;
    @ManyToOne
    @JoinColumn(name = "jobType_id")
    private JobType jobType;
    private String educationalRequirements;
    private String experience;
    private String additionalRequirements;
    @ManyToMany
    @JoinTable(
            name = "job_city",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private Set<Country> countries;
    private String salary;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public JobPosting() {
    }

    public JobPosting(String position, Company company, int vacancy, Set<JobDescription> jobDescriptions, JobType jobType, String educationalRequirements, String experience, String additionalRequirements, Set<Country> countries, String salary, User user) {
        this.position = position;
        this.company = company;
        this.vacancy = vacancy;
        this.jobDescriptions = jobDescriptions;
        this.jobType = jobType;
        this.educationalRequirements = educationalRequirements;
        this.experience = experience;
        this.additionalRequirements = additionalRequirements;
        this.countries = countries;
        this.salary = salary;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public Set<JobDescription> getJobDescriptions() {
        return jobDescriptions;
    }

    public void setJobDescriptions(Set<JobDescription> jobDescriptions) {
        this.jobDescriptions = jobDescriptions;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public String getEducationalRequirements() {
        return educationalRequirements;
    }

    public void setEducationalRequirements(String educationalRequirements) {
        this.educationalRequirements = educationalRequirements;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAdditionalRequirements() {
        return additionalRequirements;
    }

    public void setAdditionalRequirements(String additionalRequirements) {
        this.additionalRequirements = additionalRequirements;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
