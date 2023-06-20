package com.example.LearnHub.models;

import javax.persistence.*;

@Entity
@Table(name = "Badge")
public class Badge {
    // модель "бейдж" для реализации системы наград
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String badgeName;


    public Badge(String badgeName) {
        this.badgeName = badgeName;
    }

    public Badge() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }
}
