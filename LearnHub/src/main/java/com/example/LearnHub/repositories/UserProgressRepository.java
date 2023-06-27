package com.example.LearnHub.repositories;

import com.example.LearnHub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProgressRepository extends JpaRepository<User,String> {
}
