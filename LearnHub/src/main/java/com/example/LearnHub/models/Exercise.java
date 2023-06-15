package com.example.LearnHub.models;


import javax.persistence.*;

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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Exercise(String exerciseTitle, String description, Category category) {
        this.exerciseTitle = exerciseTitle;
        this.description = description;
        this.category = category;
    }

    public Exercise() {

    }
// описание упражнений

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
