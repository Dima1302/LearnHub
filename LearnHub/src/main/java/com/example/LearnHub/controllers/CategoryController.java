package com.example.LearnHub.controllers;

import com.example.LearnHub.dto.CategoryDTO;
import com.example.LearnHub.dto.SectionDTO;
import com.example.LearnHub.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryId}/sections")
    public ResponseEntity<List<SectionDTO>> getCategorySections(@PathVariable Integer categoryId) {
        List<SectionDTO> sections = categoryService.getSectionsByCategoryId(categoryId);
       return ResponseEntity.ok(sections);
    }

}
