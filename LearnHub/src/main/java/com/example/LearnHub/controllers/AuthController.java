package com.example.LearnHub.controllers;

import com.example.LearnHub.config.JwtTokenProvider;
import com.example.LearnHub.dto.*;
import com.example.LearnHub.exceptions.RegistrationException;
import com.example.LearnHub.models.User;
import com.example.LearnHub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserDTO userDTO, Model model) {
        User newUser = convertToUser(userDTO);

        try {
            userService.registerUser(newUser);
            return ResponseEntity.ok("User registered successfully");
        } catch (RegistrationException e) {
            // Обработка ошибки регистрации
            model.addAttribute("userDto", userDTO);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            // Общая обработка ошибок
            model.addAttribute("userDto", userDTO);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO) {
        try {
            // Аутентификация пользователя
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword())
            );

            // Получение UserDetails
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Генерация токена доступа
            String token = tokenProvider.generateToken(userDetails);

            // Возврат токена в ответе
            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            // Обработка ошибки аутентификации
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } catch (Exception e) {
            // Общая обработка ошибок
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed");
        }
    }

    private User convertToUser(UserDTO userDTO) {
        User user = new User();
        // Установка значений из UserDTO в User
        user.setUsername(userDTO.getUsername());
        // ...
        return user;
    }
}
