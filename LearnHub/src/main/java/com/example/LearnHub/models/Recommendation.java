package com.example.LearnHub.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Recommendation")
public class Recommendation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "recommendationTitle")
    private String recTitle;
    @Column(name = "recommendationDescription")
    private String recommendationDescription;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(mappedBy = "recommendations")
    private List<User> users = new ArrayList<>();


    // после прочтения в течении 50 минут, сделайте 50 отжиманий
}
