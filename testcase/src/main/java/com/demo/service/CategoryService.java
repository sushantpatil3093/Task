package com.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.demo.entity.Category;
import com.demo.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository ct;

    public Page<Category> getAllCategories(int page, int size) {
        return ct.findAll(PageRequest.of(page, size));
    }

    public Category createCategory(Category category) {
        return ct.save(category);
    }

    public Category getCategoryById(int id) {
        return ct.findById(id).orElse(null);
    }

    public Category updateCategory(int id, Category categoryDetails) {
        Category category = ct.findById(id).orElse(null);
        if (category != null) {
            category.setName(categoryDetails.getName());
            return ct.save(category);
        }
        return null;
    }

    public void deleteCategory(int id) {
        ct.deleteById(id);
    }
}
