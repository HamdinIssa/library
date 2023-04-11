package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showMyLoginPage() {
        return "login";
    }
    @GetMapping("/index")
    public String showMustGoOn(){
        return "index";
    }
    // add request mapping for /access-denied
    @PostMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
