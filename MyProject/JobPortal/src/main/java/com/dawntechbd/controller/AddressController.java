package com.dawntechbd.controller;


import com.dawntechbd.entity.User;
import com.dawntechbd.entity.addressDetails.*;
import com.dawntechbd.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddressController {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private DivisionRepo divisionRepo;
    @Autowired
    private DistrictRepo districtRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private UserRepo userRepo;

    //Country
    @GetMapping(value = "/ctr/add")
    public String addCountry(Model model) {
        model.addAttribute("country", new Country());
        return "address/add";
    }

    @PostMapping(value = "/ctr/add")
    public String addCountry(@Valid Country country, BindingResult bindingResult, Model model) {
        this.countryRepo.save(country);
        model.addAttribute("country", new Country());
        model.addAttribute("sucMsg", "Success !");
        return "address/add";
    }

    @GetMapping(value = "/ctr/list")
    public String countryList(Model model) {
        model.addAttribute("list", this.countryRepo.findAll());
        return "address/list";
    }

    //Division
    @GetMapping(value = "/div/add")
    public String addDivision(Model model) {
        model.addAttribute("division", new Division());
        model.addAttribute("list", this.countryRepo.findAll());
        return "address/division";
    }

    @PostMapping(value = "/div/add")
    public String addDivision(@Valid Division division, BindingResult bindingResult, Model model) {
        this.divisionRepo.save(division);
        model.addAttribute("list", this.countryRepo.findAll());
        model.addAttribute("division", new Division());
        model.addAttribute("sucMsg", "Success !");
        return "address/division";
    }

    @GetMapping(value = "/div/list")
    public String divList(Model model) {
        model.addAttribute("list", this.divisionRepo.findAll());
        return "address/divList";
    }

    //District
    @GetMapping(value = "/dist/add")
    public String addDistrict(Model model) {
        model.addAttribute("district", new District());
        model.addAttribute("list", this.divisionRepo.findAll());
        return "address/district";
    }

    @PostMapping(value = "/dist/add")
    public String addDistrict(@Valid District district, BindingResult bindingResult, Model model) {
        this.districtRepo.save(district);
        model.addAttribute("list", this.divisionRepo.findAll());
        model.addAttribute("district", new District());
        model.addAttribute("sucMsg", "Success !");
        return "address/district";
    }

    @GetMapping(value = "/dist/list")
    public String distList(Model model) {
        model.addAttribute("list", this.districtRepo.findAll());
        return "address/distList";
    }

    //City
    @GetMapping(value = "/city/add")
    public String addCity(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("list", this.districtRepo.findAll());
        return "address/city";
    }

    @PostMapping(value = "/city/add")
    public String addCity(@Valid City city, BindingResult bindingResult, Model model) {
        this.cityRepo.save(city);
        model.addAttribute("list", this.districtRepo.findAll());
        model.addAttribute("sucMsg", "Success !");
        model.addAttribute("city", new City());
        return "address/city";
    }

    @GetMapping(value = "/city/list")
    public String cityList(Model model) {
        model.addAttribute("list", this.cityRepo.findAll());
        return "address/cityList";
    }

    // Chaining Address Details
    @GetMapping(value = "/chain")
    public String testChain(Model model) {
        model.addAttribute("address", new AddressDetails());
        model.addAttribute("countryList", this.countryRepo.findAll());
        return "address/chain";
    }

    @PostMapping(value = "/chain")
    public String testChain(@Valid AddressDetails address, BindingResult bindingResult, Model model) {
        this.addressRepo.save(address);
        model.addAttribute("countryList", this.countryRepo.findAll());
        model.addAttribute("sucMsg", "Success !");
        model.addAttribute("address", new AddressDetails());
        return "address/chain";
    }

    @GetMapping(value = "/chainList")
    public String chainList(Model model) {
        model.addAttribute("list", this.addressRepo.findAll());
        return "address/chainList";
    }

    // Address Details
    @GetMapping(value = "/address")
    public String addAddress(Model model) {
        model.addAttribute("address", new AddressDetails());
        model.addAttribute("cityList", this.cityRepo.findAll());
        return "address/addressAdd";
    }

    @PostMapping(value = "/address")
    public String addAddress(@Valid AddressDetails address, BindingResult bindingResult, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        address.setUser(user);
        this.addressRepo.save(address);
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("sucMsg", "Success !");
        model.addAttribute("address", new AddressDetails());
        model.addAttribute("list", this.addressRepo.findAll());
        return "address/addressList";
    }

    @GetMapping(value = "/addressList")
    public String addressList(Model model) {
        model.addAttribute("list", this.addressRepo.findAll());
        return "address/addressList";
    }
}
