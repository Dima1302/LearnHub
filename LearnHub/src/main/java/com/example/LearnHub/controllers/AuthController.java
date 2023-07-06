package com.example.LearnHub.controllers;


import com.example.LearnHub.dto.UserDTO;

import com.example.LearnHub.services.UserService;
import com.example.LearnHub.util.UserValidator;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserValidator personValidator;
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    // остальной код контроллера

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {
        logger.debug("Performing user registration...");

        personValidator.validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            logger.debug("Validation errors detected: {}", bindingResult.getAllErrors());
            return "auth/registration";
        }

        userService.createUser(userDTO);
        logger.debug("User registration successful. Redirecting to /auth/login");
        return "redirect:/auth/login";
    }


    public AuthController(UserValidator personValidator, UserService userService) {
        this.personValidator = personValidator;
        this.userService = userService;
    }
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "auth/registration";
    }


    // Остальные методы контроллера без изменений




    @PostMapping("/login")
    public String login() {
        // остальной код метода...
        return "redirect:/home"; // замените "home" на вашу целевую страницу
    }



    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "auth/login";
    }




}
