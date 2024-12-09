package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.demo.entity.Category;
import com.demo.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

   
    @GetMapping
    public List<Category> getCategories(@RequestParam(defaultValue = "0") int page) {
        return categoryRepository.findAll(PageRequest.of(page, 10)).getContent();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

   
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable int id) {
        return categoryRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category categoryDetails) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }

   
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryRepository.deleteById(id);
    }
}
