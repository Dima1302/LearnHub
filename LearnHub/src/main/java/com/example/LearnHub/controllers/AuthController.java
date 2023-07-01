package com.example.LearnHub.controllers;


import com.example.LearnHub.dto.UserDTO;
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
    public String registrationPage(@ModelAttribute("user") UserDTO userDTO) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult bindingResult) {
        personValidator.validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "auth/registration";
        }
        userService.registerNewUser(userDTO); // Используйте метод registerNewUser для сохранения пользователя
        return "redirect:/auth/login";
    }
}
