package com.example.LearnHub.models;

import javax.persistence.*;

@Entity
@Table(name = "Achievement")
public class Achievement {
    // модель "достижение"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "achievementName")
    private String achievementName;


    public Achievement(String achievementName) {
        this.achievementName = achievementName;
    }

    public Achievement() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }
}
