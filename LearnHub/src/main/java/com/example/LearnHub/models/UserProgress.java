package com.example.LearnHub.models;



import javax.persistence.*;
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

    public UserProgress(User user, Category category, List<Recommendation> completedRecommendations) {
        this.user = user;
        this.category = category;
        this.completedRecommendations = completedRecommendations;
    }

    public UserProgress() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Recommendation> getCompletedRecommendations() {
        return completedRecommendations;
    }

    public void setCompletedRecommendations(List<Recommendation> completedRecommendations) {
        this.completedRecommendations = completedRecommendations;
    }
}
