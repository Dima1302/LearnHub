package com.example.LearnHub.repositories;

import com.example.LearnHub.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,String> {
}
