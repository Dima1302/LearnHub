package com.example.LearnHub.repositories;

import com.example.LearnHub.models.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement,Integer> {
}
