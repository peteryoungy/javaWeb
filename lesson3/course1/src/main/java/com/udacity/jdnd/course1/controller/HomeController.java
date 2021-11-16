package com.udacity.jdnd.course1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //the return value gives which template to use for this url
    @RequestMapping("/home")
    public String getHomePage(){
        return "home";
    }

}
