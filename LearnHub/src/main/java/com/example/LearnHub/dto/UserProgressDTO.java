package com.example.LearnHub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserProgressDTO {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("completed_recommendation_ids")
    private List<Long> completedRecommendationIds;
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Long> getCompletedRecommendationIds() {
        return completedRecommendationIds;
    }

    public void setCompletedRecommendationIds(List<Long> completedRecommendationIds) {
        this.completedRecommendationIds = completedRecommendationIds;
    }


}
