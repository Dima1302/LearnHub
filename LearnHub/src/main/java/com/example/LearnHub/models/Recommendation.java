package com.example.LearnHub.models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Recommendation")
public class Recommendation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Recommendation(String recTitle, String recommendationDescription, Category category, List<User> users) {
        this.recTitle = recTitle;
        this.recommendationDescription = recommendationDescription;
        this.category = category;
        this.users = users;
    }

    @Column(name = "recommendationTitle")
    private String recTitle;
    @Column(name = "recommendationDescription")
    private String recommendationDescription;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(mappedBy = "recommendations")
    private List<User> users = new ArrayList<>();

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;


    public Recommendation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecTitle() {
        return recTitle;
    }

    public void setRecTitle(String recTitle) {
        this.recTitle = recTitle;
    }

    public String getRecommendationDescription() {
        return recommendationDescription;
    }

    public void setRecommendationDescription(String recommendationDescription) {
        this.recommendationDescription = recommendationDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    // после прочтения в течении 50 минут, сделайте 50 отжиманий
}
