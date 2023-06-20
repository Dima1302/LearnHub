package com.example.LearnHub.repositories;

import com.example.LearnHub.models.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge,Integer> {
}
