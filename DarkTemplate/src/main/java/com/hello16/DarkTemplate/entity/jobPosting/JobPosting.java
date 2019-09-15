package com.hello16.DarkTemplate.entity.jobPosting;

import com.hello16.DarkTemplate.entity.addressDetails.City;

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
    private String jobDescriptions;
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
    private Set<City> cities;
    private int salary;

    public JobPosting() {
    }

    public JobPosting(String position, Company company, int vacancy, String jobDescriptions, JobType jobType, String educationalRequirements, String experience, String additionalRequirements, Set<City> cities, int salary) {
        this.position = position;
        this.company = company;
        this.vacancy = vacancy;
        this.jobDescriptions = jobDescriptions;
        this.jobType = jobType;
        this.educationalRequirements = educationalRequirements;
        this.experience = experience;
        this.additionalRequirements = additionalRequirements;
        this.cities = cities;
        this.salary = salary;
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

    public String getJobDescriptions() {
        return jobDescriptions;
    }

    public void setJobDescriptions(String jobDescriptions) {
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

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
