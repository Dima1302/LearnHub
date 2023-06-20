package com.example.LearnHub.services;

import com.example.LearnHub.models.Achievement;
import com.example.LearnHub.repositories.AchievementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService {
    private final AchievementRepository achievementRepository;

    public AchievementService(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    public List<Achievement>getAllAchievements() {
        return achievementRepository.findAll();
    }
}
