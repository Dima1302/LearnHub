package com.example.LearnHub.services;

import com.example.LearnHub.dto.CategoryDTO;
import com.example.LearnHub.dto.SectionDTO;
import com.example.LearnHub.models.Category;
import com.example.LearnHub.models.Section;
import com.example.LearnHub.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        // Преобразование списка моделей Category в список DTO CategoryDTO
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO categoryDTO = new CategoryDTO();
            // Заполнение полей DTO из модели
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
            // Другие поля, если есть

            categoryDTOs.add(categoryDTO);
        }
        return categoryDTOs;
    }
    public List<SectionDTO> getSectionsByCategoryId(int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Категория с указанным ID не найдена"));

        List<Section> sections = category.getSections();
        // Преобразование списка разделов в список DTO
        List<SectionDTO> sectionDTOs = sections.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return sectionDTOs;
    }

    private SectionDTO convertToDTO(Section section) {
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setId(section.getId());
        sectionDTO.setSectionName(section.getSectionName());
        // Другие поля, если необходимо
        return sectionDTO;
    }
}
