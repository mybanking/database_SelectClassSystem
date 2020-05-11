package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController {



    @GetMapping("/set1")
    public String set1(HttpSession session) {
        session.setAttribute("tudou", "mongodb");
        return String.valueOf(8080);
    }

    @GetMapping("/get")
    public String get(HttpSession session) {
        return session.getAttribute("tudou") + ":" + 8080;
    }
}