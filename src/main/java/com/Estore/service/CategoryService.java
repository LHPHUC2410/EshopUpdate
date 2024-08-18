package com.Estore.service;

import com.Estore.dto.reponse.CategoryResponse;
import com.Estore.dto.request.CategoryRequest;
import com.Estore.entity.Category;
import com.Estore.mapper.CategoryMapper;
import com.Estore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public Category create(CategoryRequest request) {
        Category category = categoryMapper.toCategory(request);
        return categoryRepository.save(category);
    }

    public List<CategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toCategoryResponse).toList();
    }

    public CategoryResponse getById(String id) {
        return categoryMapper.toCategoryResponse(categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found")));
    }

    public void delete(String id)
    {
        categoryRepository.deleteById(id);
    }
}
