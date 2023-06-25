package com.example.LearnHub.models;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


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

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public List<UserProgress> getProgress() {
        return progress;
    }

    public void setProgress(List<UserProgress> progress) {
        this.progress = progress;
    }

    @ManyToMany
    @JoinTable(
            name = "user_recommendation",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recommendation_id")
    )
    private List<Recommendation> recommendations = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserProgress> progress = new ArrayList<>();

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    @ManyToMany
    private List<Badge> badges;

    @ManyToMany
    private List<Achievement> achievements;
    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Message> sentMessages = new ArrayList<>();

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Message> receivedMessages = new ArrayList<>();



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
