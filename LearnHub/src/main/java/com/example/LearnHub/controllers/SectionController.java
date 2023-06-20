package com.example.LearnHub.controllers;


import com.example.LearnHub.dto.ExerciseDTO;
import com.example.LearnHub.dto.RecommendationDTO;

import com.example.LearnHub.services.ExerciseService;
import com.example.LearnHub.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/sections")
public class SectionController {
    private final SectionService sectionService;
    private final ExerciseService exerciseService;

    @Autowired
    public SectionController(SectionService sectionService, ExerciseService exerciseService) {
        this.sectionService = sectionService;
        this.exerciseService = exerciseService;
    }

    @GetMapping("/{sectionId}/recommendations")
    public ResponseEntity<List<RecommendationDTO>> getRecommendationsBySection(@PathVariable Integer sectionId) {
        List<RecommendationDTO> recommendations = sectionService.getRecommendationBySectionId(sectionId);
        return ResponseEntity.ok(recommendations); // Реализация получения списка рекомендаций внутри раздела
    }

    @GetMapping("/{sectionId}/exercises")
    public ResponseEntity<List<ExerciseDTO>> getExercisesInSection(@PathVariable int sectionId) {
        List<ExerciseDTO> exerciseDTOs = exerciseService.getExercisesBySectionId(sectionId);
        return ResponseEntity.ok(exerciseDTOs);
    }

}
