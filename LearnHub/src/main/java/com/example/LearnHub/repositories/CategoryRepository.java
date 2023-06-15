package com.example.LearnHub.repositories;

import com.example.LearnHub.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
