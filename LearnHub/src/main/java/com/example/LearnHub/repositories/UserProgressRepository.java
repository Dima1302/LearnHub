package com.example.LearnHub.repositories;

import com.example.LearnHub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProgressRepository extends JpaRepository<User,String> {
}
