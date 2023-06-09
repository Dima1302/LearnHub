package com.example.LearnHub.models;

import jakarta.persistence.*;

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
    private Category category;

    // после прочтения в течении 50 минут, сделайте 50 отжиманий
}
