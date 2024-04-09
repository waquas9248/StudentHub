package com.app.studenthub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginErrorController {

    @GetMapping("/login-failed")
    public String loginFailed() {
        return "login-failed"; // Name of the Thymeleaf template for the access denied page
    }
}
