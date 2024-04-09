package com.app.studenthub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccessErrorController {

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied"; // Name of the Thymeleaf template for the access denied page
    }
}
