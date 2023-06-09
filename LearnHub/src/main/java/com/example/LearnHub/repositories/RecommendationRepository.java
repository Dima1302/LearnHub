package com.example.LearnHub.repositories;

import com.example.LearnHub.models.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation,String> {
}
