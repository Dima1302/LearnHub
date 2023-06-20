package com.example.LearnHub.services;

import com.example.LearnHub.models.Badge;
import com.example.LearnHub.repositories.BadgeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeService {
    private final BadgeRepository badgeRepository;

    public BadgeService(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }


}
