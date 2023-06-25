package com.example.LearnHub.dto;


import javax.validation.constraints.NotBlank;

public class ExerciseDTO {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    @NotBlank(message = "Exercise title should not be blank")
    private String exerciseTitle;

    @NotBlank(message = "Description should not be blank")
    private String description;

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


}
