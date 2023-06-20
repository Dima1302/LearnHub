package com.example.LearnHub.services;

import com.example.LearnHub.dto.ExerciseDTO;
import com.example.LearnHub.models.Exercise;
import com.example.LearnHub.models.Section;
import com.example.LearnHub.repositories.ExerciseRepository;
import com.example.LearnHub.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final SectionRepository sectionRepository;
@Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, SectionRepository sectionRepository) {
        this.exerciseRepository = exerciseRepository;
    this.sectionRepository = sectionRepository;
}

    public List<ExerciseDTO> getExercisesBySectionId(int sectionId) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new RuntimeException("Раздел с указанным ID не найден"));
        List<Exercise> exercises = section.getExercises();
        List<ExerciseDTO> exerciseDTOs = exercises.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return exerciseDTOs;
    }

    private ExerciseDTO convertToDTO(Exercise exercise) {
        ExerciseDTO exerciseDTO = new ExerciseDTO();
        exerciseDTO.setId(exercise.getId());
        exerciseDTO.setExerciseTitle(exercise.getExerciseTitle());
        exerciseDTO.setDescription(exercise.getDescription());

        return exerciseDTO;
    }
}



