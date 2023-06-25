package com.example.LearnHub.dto;


import javax.validation.constraints.NotEmpty;

public class CategoryDTO {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @NotEmpty(message = "Name should not be empty")
    private String description;

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


}
