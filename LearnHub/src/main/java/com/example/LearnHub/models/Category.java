package com.example.LearnHub.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @Column(name = "description")
    @NotEmpty(message = "Name should not be empty")
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)//mappedBy = "category" указывает,
    // что связь управляется полем category в классе Section.
    // Аннотация orphanRemoval = true указывает, что связанные секции будут удалены при удалении категории.
    private List<Section> sections = new ArrayList<>();


    public Category(String name, String description, List<Section> sections) {
        this.name = name;
        this.description = description;
        this.sections = sections;
    }

    public Category() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    /// категория для обучения : Языки, Психология и тд
}
