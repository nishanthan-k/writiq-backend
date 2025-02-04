package com.writiq.blog.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.writiq.blog.domain.dtos.CategoryDTO;
import com.writiq.blog.domain.dtos.CreateCategoryRequest;
import com.writiq.blog.domain.entities.Category;
import com.writiq.blog.services.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<CategoryDTO>> listCategories() {
        System.out.println("___+++REACHED CONTROLLER+++___");
        List<Category> categories = categoryService.listCategories();

        List<CategoryDTO> categoryDtos = categories.stream()
                .map(catrgory -> new CategoryDTO(catrgory.getId(), catrgory.getName()))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(categoryDtos);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CreateCategoryRequest category) {
        Category newCategory = categoryService.createCatgory(category);
    }
}
