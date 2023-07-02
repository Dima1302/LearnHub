package com.example.LearnHub.services;

import com.example.LearnHub.dto.RecommendationDTO;
import com.example.LearnHub.dto.UserDTO;
import com.example.LearnHub.models.*;
import com.example.LearnHub.repositories.AchievementRepository;
import com.example.LearnHub.repositories.BadgeRepository;
import com.example.LearnHub.repositories.RecommendationRepository;
import com.example.LearnHub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RecommendationRepository recommendationRepository;
    private final BadgeRepository badgeRepository;
    private final AchievementRepository achievementRepository;

    @Autowired
    public UserService(UserRepository userRepository, RecommendationRepository recommendationRepository, BadgeRepository badgeRepository, AchievementRepository achievementRepository) {
        this.userRepository = userRepository;
        this.recommendationRepository = recommendationRepository;
        this.badgeRepository = badgeRepository;
        this.achievementRepository = achievementRepository;
    }

    @Transactional
    public User registerNewUser(UserDTO userDTO) {
        User user = convertToUser(userDTO);
        return userRepository.save(user);
    }

    public List<RecommendationDTO> getUserProgress(int userId) {
        User user = getUserById(userId);
        List<Recommendation> userRecommendations = user.getRecommendations();

        return userRecommendations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь с указанным ID не найден"));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Пользователь с указанным именем пользователя не найден"));
    }

    public User createUser(UserDTO userDTO) {
        User user = convertToUser(userDTO);
        return userRepository.save(user);
    }

    private RecommendationDTO convertToDTO(Recommendation recommendation) {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        recommendationDTO.setId(recommendation.getId());
        recommendationDTO.setRecTitle(recommendation.getRecTitle());
        recommendationDTO.setRecommendationDescription(recommendation.getRecommendationDescription());

        return recommendationDTO;
    }

    public void completeRecommendation(int userId, int recommendationId) {
        User user = getUserById(userId);
        Recommendation recommendation = recommendationRepository.findById(recommendationId)
                .orElseThrow(() -> new RuntimeException("Рекомендация с указанным ID не найдена"));

        Category category = recommendation.getCategory();
        UserProgress userProgress = new UserProgress(user, category, Collections.singletonList(recommendation));
        user.getProgress().add(userProgress);

        userRepository.save(user);
    }

    public void assignBadgeToUser(int userId) {
        User user = getUserById(userId);
        int numMaterialsStudied = user.getRecommendations().size();
        int numExercisesCompleted = user.getProgress().stream()
                .mapToInt(progress -> progress.getCompletedRecommendations().size())
                .sum();

        int numBadgesToAssign = Math.min(numMaterialsStudied, numExercisesCompleted);

        List<Badge> badges = new ArrayList<>();
        for (int i = 0; i < numBadgesToAssign; i++) {
            Badge badge = new Badge("Badge " + (i + 1));
            badges.add(badge);
        }

        user.setBadges(badges);

        userRepository.save(user);
    }

    public void completeAchievement(int userId) {
        User user = getUserById(userId);
        int numBadges = user.getBadges().size();
        String achievement = "";

        if (numBadges < 5) {
            achievement = "Школьник-слизняк";
        } else if (numBadges >= 5 && numBadges < 10) {
            achievement = "Школьник-турникмен";
        } else if (numBadges >= 10 && numBadges < 20) {
            achievement = "Студент-химик";
        } else if (numBadges >= 20) {
            achievement = "Магистр протеиновых наук";
        }

        Achievement userAchievement = new Achievement(achievement);
        user.setAchievements(Collections.singletonList(userAchievement));

        userRepository.save(user);
    }

    private User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setSportLevel(userDTO.getSportLevel());
        // Добавьте код для преобразования других полей из UserDTO в User, если такие поля есть
        return user;
    }
}

