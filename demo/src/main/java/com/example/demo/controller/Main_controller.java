package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Main_controller {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/Classroom")
    public String classroom(){
        return "Classroom";
    }

    @RequestMapping("/Home")
    public String Home(){
        return "Home";
    }

    @RequestMapping("/course")
    public String Course(){
        return "course";
    }

    @RequestMapping("/Project")
    public String project(){
        return "Project";
    }

    @RequestMapping("/Information")
    public String information(){
        return "Information";
    }

    @RequestMapping("/Award")
    public String Award(){
        return "Award";
    }

    @RequestMapping("/select_course")
    public String Select(){
        return "select_course";
    }





}
