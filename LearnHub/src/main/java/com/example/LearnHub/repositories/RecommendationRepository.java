package com.example.LearnHub.repositories;

import com.example.LearnHub.models.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Integer> {
}
