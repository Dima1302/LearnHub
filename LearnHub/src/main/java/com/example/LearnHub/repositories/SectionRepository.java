package com.example.LearnHub.repositories;

import com.example.LearnHub.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section,Integer> {
}
