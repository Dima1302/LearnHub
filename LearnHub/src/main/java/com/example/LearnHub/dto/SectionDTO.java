package com.example.LearnHub.dto;


import javax.validation.constraints.NotEmpty;

public class SectionDTO {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    @NotEmpty(message = "Name should not be empty")
    private String sectionName;

    @NotEmpty(message = "Section description should not be empty")
    private String sectionDescription;

    @NotEmpty(message = "MaterialLink should not be empty")
    private String materialsLink;

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
}
