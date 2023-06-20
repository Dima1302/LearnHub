package com.example.LearnHub.controllers;

import com.example.LearnHub.dto.RecommendationDTO;
import com.example.LearnHub.models.Achievement;
import com.example.LearnHub.models.Badge;
import com.example.LearnHub.models.User;
import com.example.LearnHub.services.AchievementService;
import com.example.LearnHub.services.BadgeService;
import com.example.LearnHub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
private final UserService userService;
    private final BadgeService badgeService;
    private final AchievementService achievementService;

@Autowired
    public UserController(UserService userService, BadgeService badgeService, AchievementService achievementService) {
        this.userService = userService;
    this.badgeService = badgeService;
    this.achievementService = achievementService;
}

    @GetMapping("/{userId}/progress")
    public ResponseEntity<List<RecommendationDTO>> getUserProgress(@PathVariable Integer userId) {
        List<RecommendationDTO>userProgress = userService.getUserProgress(userId);
        return ResponseEntity.ok(userProgress);// Реализация получения списка выполненных рекомендаций пользователя
    }

    @PostMapping("/{userId}/recommendations/{recommendationId}/complete")
    public ResponseEntity<String> completeRecommendation(@PathVariable int userId, @PathVariable int recommendationId) {
        // Логика завершения рекомендации пользователем
       userService.completeRecommendation(userId,recommendationId);  // Пример: userService.completeRecommendation(userId, recommendationId);

        return ResponseEntity.ok("Recommendation completed successfully");
    }



    @GetMapping("/{userId}/badges")
    public ResponseEntity<List<Badge>> getUserBadges(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        List<Badge> badges = user.getBadges();
        return ResponseEntity.ok(badges);
    }

    @GetMapping("/{userId}/achievements")
    public ResponseEntity<List<Achievement>> getUserAchievements(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        List<Achievement> achievements = user.getAchievements();
        return ResponseEntity.ok(achievements);
    }

    @PostMapping("/{userId}/badges/assign")
    public ResponseEntity<String> assignBadgeToUser(@PathVariable int userId) {
        userService.assignBadgeToUser(userId);
        return ResponseEntity.ok("Badge assigned successfully");
    }

    @PostMapping("/{userId}/achievements/complete")
    public ResponseEntity<String> completeAchievement(@PathVariable int userId) {
        userService.completeAchievement(userId);
        return ResponseEntity.ok("Achievement completed successfully");
    }



}
