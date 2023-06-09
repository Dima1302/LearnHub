package com.example.LearnHub.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

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
