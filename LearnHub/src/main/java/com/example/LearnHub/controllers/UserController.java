package com.example.LearnHub.controllers;

import com.example.LearnHub.dto.RecommendationDTO;
import com.example.LearnHub.models.Achievement;
import com.example.LearnHub.models.Badge;
import com.example.LearnHub.models.User;
import com.example.LearnHub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{userId}/progress")
    public ResponseEntity<List<RecommendationDTO>> getUserProgress(@PathVariable Integer userId) {
        List<RecommendationDTO> userProgress = userService.getUserProgress(userId);
        return ResponseEntity.ok(userProgress);
    }

    @PostMapping("/user/{userId}/recommendations/{recommendationId}/complete")
    public ResponseEntity<String> completeRecommendation(@PathVariable int userId, @PathVariable int recommendationId) {
        userService.completeRecommendation(userId, recommendationId);
        return ResponseEntity.ok("Recommendation completed successfully");
    }

    @GetMapping("/user/{userId}/badges")
    public ResponseEntity<List<Badge>> getUserBadges(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        List<Badge> badges = user.getBadges();
        return ResponseEntity.ok(badges);
    }

    @GetMapping("/user/{userId}/achievements")
    public ResponseEntity<List<Achievement>> getUserAchievements(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        List<Achievement> achievements = user.getAchievements();
        return ResponseEntity.ok(achievements);
    }

    @PostMapping("/user/{userId}/badges/assign")
    public ResponseEntity<String> assignBadgeToUser(@PathVariable int userId) {
        userService.assignBadgeToUser(userId);
        return ResponseEntity.ok("Badge assigned successfully");
    }

    @PostMapping("/user/{userId}/achievements/complete")
    public ResponseEntity<String> completeAchievement(@PathVariable int userId) {
        userService.completeAchievement(userId);
        return ResponseEntity.ok("Achievement completed successfully");
    }
}



