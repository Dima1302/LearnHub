package com.example.LearnHub.services;

import com.example.LearnHub.dto.RecommendationDTO;

import com.example.LearnHub.models.Recommendation;
import com.example.LearnHub.models.Section;
import com.example.LearnHub.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionService {
    private final SectionRepository sectionRepository;

@Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public List<RecommendationDTO> getRecommendationBySectionId(int sectionId) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new RuntimeException("Раздел с указанным ID не найден"));

        List<Recommendation> recommendation = section.getRecommendations();
        // Преобразование списка разделов в список DTO
        List<RecommendationDTO> recommendationDTO =recommendation.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return recommendationDTO;
    }

    private RecommendationDTO convertToDTO(Recommendation recommendation) {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        recommendationDTO.setRecTitle(recommendation.getRecTitle());
        recommendationDTO.setRecommendationDescription(recommendation.getRecommendationDescription());
        // Другие поля, если необходимо
        return recommendationDTO;
    }
}
