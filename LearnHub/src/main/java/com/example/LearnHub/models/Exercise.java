package com.example.LearnHub.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Exercise")
public class Exercise {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "exerciseTitle")
    private String exerciseTitle;
    @Column(name = "exerciseDescription")
    private String description;


    private Category category;// описание упражнений
}
