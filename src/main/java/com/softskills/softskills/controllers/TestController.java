package com.softskills.softskills.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @GetMapping("/")
    public String home() {
        return "index"; // Nome do arquivo HTML sem a extensão
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }


}
