package com.app.studenthub.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String home(Model model, @AuthenticationPrincipal OAuth2User principal) {
        // Assuming you want to display user's email on the home page
        String email = principal.getAttribute("email");
        model.addAttribute("email", email);
        return "home"; // Name of the Thymeleaf template for the home page
    }

}
