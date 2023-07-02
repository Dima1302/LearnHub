package com.example.LearnHub.controllers;


import com.example.LearnHub.dto.UserDTO;
import com.example.LearnHub.models.User;
import com.example.LearnHub.services.UserService;
import com.example.LearnHub.util.UserValidator;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
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
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "auth/registration";
    }


    // Остальные методы контроллера без изменений

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {
        personValidator.validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "auth/registration";
        }

        userService.createUser(userDTO); // Используем метод createUser из UserService, передавая userDTO

        return "redirect:/auth/login";
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        // остальной код метода...
        return ResponseEntity.ok().build();
    }


    private User convertUserDtoToUser(UserDTO userDTO) {
        // Преобразование UserDTO в User
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setSportLevel(userDTO.getSportLevel());
        return user;
    }
}
