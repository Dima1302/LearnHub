package com.example.LearnHub.dto;


import javax.validation.constraints.NotBlank;

public class RecommendationDTO {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    @NotBlank(message = "Recommendation title should not be blank")
    private String recTitle;
    @NotBlank(message = "Recommendation description should not be blank")
    private String recommendationDescription;
}
