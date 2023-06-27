package com.example.LearnHub.controllers;


import com.example.LearnHub.models.User;
import com.example.LearnHub.services.UserService;
import com.example.LearnHub.util.UserValidator;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserValidator personValidator;
    private final UserService userService;

    public AuthController(UserValidator personValidator, UserService userService) {
        this.personValidator = personValidator;
        this.userService = userService;
    }


    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid User user, BindingResult bindingResult) {
        personValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "auth/registration";
        }
        userService.registerUser(user);
        return "redirect:/auth/login";
    }
}
