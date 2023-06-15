package com.example.LearnHub.models;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Section")
public class Section {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sectionName")
    @NotEmpty(message = "Name should not be empty")
    private String sectionName;
    @Column(name = "sectionDescription")
    @NotEmpty(message = "Name should not be empty")
    private String sectionDescription;

    @Column(name = "materialsLink")
    private String materialsLink;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exercises = new ArrayList<>();

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }


    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recommendation> recommendations = new ArrayList<>();



    public Section(String sectionName, String sectionDescription, String materialsLink) {
        this.sectionName = sectionName;
        this.sectionDescription = sectionDescription;
        this.materialsLink = materialsLink;
    }

    public Section() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public String getMaterialsLink() {
        return materialsLink;
    }

    public void setMaterialsLink(String materialsLink) {
        this.materialsLink = materialsLink;
    }
    /// конкретный раздел : Психология - сам материал и ссылка на него
}
