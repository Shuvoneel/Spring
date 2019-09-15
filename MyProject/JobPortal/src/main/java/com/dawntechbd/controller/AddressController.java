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
import org.springframework.web.bind.annotation.*;

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

    // ADD Address Details
    @GetMapping(value = "/address")
    public String addAddress(Model model) {
        model.addAttribute("address", new AddressDetails());
        model.addAttribute("countryList", this.countryRepo.findAll());
        model.addAttribute("divList", this.divisionRepo.findAll());
        model.addAttribute("distList", this.districtRepo.findAll());
        model.addAttribute("cityList", this.cityRepo.findAll());
        return "address/addressAdd";
    }

    @PostMapping(value = "/address")
    public String addAddress(@Valid AddressDetails address, BindingResult bindingResult, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        address.setUser(user);
        this.addressRepo.save(address);
        model.addAttribute("countryList", this.countryRepo.findAll());
        model.addAttribute("divList", this.divisionRepo.findAll());
        model.addAttribute("distList", this.districtRepo.findAll());
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("address", new AddressDetails());
        model.addAttribute("list", this.addressRepo.findAll());

        return "redirect:/adrsListById";
    }


    // EDIT Address Details
    @GetMapping(value = "/address/edit/{id}")
    public String editAddress(Model model, @PathVariable("id") Long id) {
        model.addAttribute("address", this.addressRepo.getOne(id));
        model.addAttribute("countryList", this.countryRepo.findAll());
        model.addAttribute("divList", this.divisionRepo.findAll());
        model.addAttribute("distList", this.districtRepo.findAll());
        model.addAttribute("cityList", this.cityRepo.findAll());

        return "address/edit";
    }

    @PostMapping(value = "/address/edit/{id}")
    public String editAddress(@Valid AddressDetails address, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(auth.getName());
        address.setUser(user);
        this.addressRepo.save(address);
        model.addAttribute("countryList", this.countryRepo.findAll());
        model.addAttribute("divList", this.divisionRepo.findAll());
        model.addAttribute("distList", this.districtRepo.findAll());
        model.addAttribute("cityList", this.cityRepo.findAll());
        model.addAttribute("address", new AddressDetails());
        model.addAttribute("list", this.addressRepo.findAll());

        return "redirect:/adrsListById";
    }


    // DELETE Address
    @RequestMapping(value = "/address/del/{id}", method = RequestMethod.GET)
    public String delAddress(@PathVariable("id") Long id) {
        this.addressRepo.deleteById(id);

        return "redirect:/adrsListById";
    }

    // Address List
    @GetMapping(value = "/addressList")
    public String addressList(Model model) {
        model.addAttribute("list", this.addressRepo.findAll());
        return "address/addressList";
    }

    // Address ListById
    @GetMapping(value = "/adrsListById")
    public String adrsListById(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUsername(authentication.getName());
        model.addAttribute("listById", this.addressRepo.findAllByUser(user));
        return "address/adrsListById";
    }

    //Country
    @GetMapping(value = "/ctr/add")
    public String addCountry(Model model) {
        model.addAttribute("country", new Country());
        model.addAttribute("sucMsg", "Country Added !");
        return "address/add";
    }

    @PostMapping(value = "/ctr/add")
    public String addCountry(@Valid Country country, BindingResult bindingResult, Model model) {
        this.countryRepo.save(country);
        model.addAttribute("country", new Country());
        model.addAttribute("sucMsg", "Country Added !");
        return "address/add";
    }

    @GetMapping(value = "/ctr/list")
    public String countryList(Model model) {
        model.addAttribute("list", this.countryRepo.findAll());
        return "address/list";
    }

    //Division
    @GetMapping(value = "/division/add")
    public String addDivision(Model model) {
        model.addAttribute("division", new Division());
        model.addAttribute("list", this.countryRepo.findAll());
        model.addAttribute("sucMsg", "Division Added !");
        return "address/division";
    }

    @PostMapping(value = "/division/add")
    public String addDivision(@Valid Division division, BindingResult bindingResult, Model model) {
        this.divisionRepo.save(division);
        model.addAttribute("list", this.countryRepo.findAll());
        model.addAttribute("division", new Division());
        model.addAttribute("sucMsg", "Division Added !");
        return "address/division";
    }

    @GetMapping(value = "/division/list")
    public String divList(Model model) {
        model.addAttribute("list", this.divisionRepo.findAll());
        return "address/divList";
    }

    //District
    @GetMapping(value = "/dist/add")
    public String addDistrict(Model model) {
        model.addAttribute("district", new District());
        model.addAttribute("list", this.divisionRepo.findAll());
        model.addAttribute("sucMsg", "District Added !");
        return "address/district";
    }

    @PostMapping(value = "/dist/add")
    public String addDistrict(@Valid District district, BindingResult bindingResult, Model model) {
        this.districtRepo.save(district);
        model.addAttribute("list", this.divisionRepo.findAll());
        model.addAttribute("district", new District());
        model.addAttribute("sucMsg", "District Added !");
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
        model.addAttribute("sucMsg", "City Added !");
        return "address/city";
    }

    @PostMapping(value = "/city/add")
    public String addCity(@Valid City city, BindingResult bindingResult, Model model) {
        this.cityRepo.save(city);
        model.addAttribute("list", this.districtRepo.findAll());
        model.addAttribute("city", new City());
        model.addAttribute("sucMsg", "City Added !");
        return "address/city";
    }

    @GetMapping(value = "/city/list")
    public String cityList(Model model) {
        model.addAttribute("list", this.cityRepo.findAll());
        return "address/cityList";
    }

    // Chaining Details
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
        model.addAttribute("address", new AddressDetails());
        return "address/chain";
    }

    @GetMapping(value = "/chainList")
    public String chainList(Model model) {
        model.addAttribute("list", this.addressRepo.findAll());
        return "address/chainList";
    }

}
