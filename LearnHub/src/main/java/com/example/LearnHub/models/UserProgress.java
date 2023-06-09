package com.example.LearnHub.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "UserProgress")
public class UserProgress {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private User user;

    private Category category;

    private List<Recommendation> completedRecommendations;
}
