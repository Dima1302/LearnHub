package com.example.LearnHub.util;

import com.example.LearnHub.dto.UserDTO;
import com.example.LearnHub.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserDetailsService userDetailsService;

    public UserValidator(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }




@Override
public void validate(Object target, Errors errors) {
    UserDTO userDTO = (UserDTO) target;

    // Проверка поля username
    String username = userDTO.getUsername();
    if (username == null || username.isEmpty()) {
        errors.rejectValue("username", "error.username", "Username is required");
    }

    // Проверка поля email
    String email = userDTO.getEmail();
    if (email == null || email.isEmpty()) {
        errors.rejectValue("email", "error.email", "Email is required");
    } else if (!isValidEmail(email)) {
        errors.rejectValue("email", "error.email", "Invalid email format");
    }

    // Проверка поля password
    String password = userDTO.getPassword();
    if (password == null || password.isEmpty()) {
        errors.rejectValue("password", "error.password", "Password is required");
    } else if (password.length() < 6) {
        errors.rejectValue("password", "error.password", "Password must be at least 6 characters long");
    }

    // Продолжайте проверять остальные поля...

}

    private boolean isValidEmail(String email) {
        // Реализуйте свою логику проверки формата email
        // Например, с использованием регулярного выражения
        return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
    }

}

