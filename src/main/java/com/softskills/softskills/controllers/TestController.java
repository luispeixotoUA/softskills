package com.softskills.softskills.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Softskills!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }


}
