package com.example.LearnHub.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2,max = 30,message = "Name should be between 2 and 30 characters")
    private String username;
    @Column(name = "email")
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @Column(name = "sportlevel")
    @NotNull
    @Enumerated(EnumType.STRING)
    private SportLevel sportLevel;//Пользователь при регистрации указывает свой физический уровень

    public User(String username, String email, String password, SportLevel sportLevel) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.sportLevel = sportLevel;
    }

    public User() {

    }

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

    public SportLevel getSportLevel() {
        return sportLevel;
    }

    public void setSportLevel(SportLevel sportLevel) {
        this.sportLevel = sportLevel;
    }

    public enum SportLevel {
        BEGINNER, // Никогда не занимался спортом
        AMATEUR,  // Любитель
        ATHLETE   // Атлет
    }




}
