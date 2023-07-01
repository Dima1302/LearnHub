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


    public User registerNewUser(UserDTO userDTO) {
        User user = convertToUser(userDTO);
        return userRepository.save(user);
    }


    public List<RecommendationDTO> getUserProgress(@PathVariable int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь с указанным ID не найден"));

        List<Recommendation> userRecommendations = user.getRecommendations();

        List<RecommendationDTO> recommendationDTOs = userRecommendations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return recommendationDTOs;
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь с указанным ID не найден"));
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Пользователь с указанным именем пользователя не найден"));
    }



    private RecommendationDTO convertToDTO(Recommendation recommendation) {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        recommendationDTO.setId(recommendation.getId());
        recommendationDTO.setRecTitle(recommendation.getRecTitle());
        recommendationDTO.setRecommendationDescription(recommendation.getRecommendationDescription());

        return recommendationDTO;
    }

    public void completeRecommendation(int userId, int recommendationId) {
        // Находим пользователя по userId в репозитории
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь с указанным ID не найден"));

        // Ищем рекомендацию по recommendationId в списке рекомендаций пользователя
        Recommendation recommendation = user.getRecommendations().stream()
                .filter(rec -> rec.getId() == recommendationId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Рекомендация с указанным ID не найдена"));

        // Получаем категорию из найденной рекомендации
        Category category = recommendation.getCategory();

        // Создаем объект UserProgress с переданными параметрами: пользователь, категория и список завершенных рекомендаций
        UserProgress userProgress = new UserProgress(user, category, Collections.singletonList(recommendation));

        // Добавляем созданный объект UserProgress в список прогресса пользователя
        user.getProgress().add(userProgress);

        // Сохраняем изменения в репозитории
        userRepository.save(user);
    }


    public void assignBadgeToUser(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь с указанным ID не найден"));

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
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь с указанным ID не найден"));

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
    public User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        // Добавьте код для преобразования других полей из UserDTO в User, если такие поля есть

        return user;
    }


}

