package com.example.LearnHub.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "UserProgress")
public class UserProgress {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToMany
    @JoinTable(
            name = "userprogress_recommendation",
            joinColumns = @JoinColumn(name = "userprogress_id"),
            inverseJoinColumns = @JoinColumn(name = "recommendation_id")
    )
    private List<Recommendation> completedRecommendations = new ArrayList<>();

}
