package com.example.LearnHub.repositories;

import com.example.LearnHub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
