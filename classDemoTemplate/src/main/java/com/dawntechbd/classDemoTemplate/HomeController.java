package com.dawntechbd.classDemoTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String displayIndex(){
        return "index";
    }

    @GetMapping(value = "/about")
    public String displayAbout(){
        return "about";
    }
}
