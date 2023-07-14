package com.example.LearnHub.dto;


import com.example.LearnHub.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class UserDTO {


    @NotBlank(message = "Имя пользователя не может быть пустым")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String username;

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Некорректный формат email")
    private String email;
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    private List<String> roles;

    public User.SportLevel getSportLevel() {
        return sportLevel;
    }

    public void setSportLevel(User.SportLevel sportLevel) {
        this.sportLevel = sportLevel;
    }

    private User.SportLevel sportLevel;

    private int id;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and setters
}
