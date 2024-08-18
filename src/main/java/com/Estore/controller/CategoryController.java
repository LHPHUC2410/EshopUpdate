package com.Estore.controller;

import com.Estore.dto.reponse.ApiResponse;
import com.Estore.dto.reponse.CategoryResponse;
import com.Estore.dto.request.CategoryRequest;
import com.Estore.entity.Category;
import com.Estore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public ApiResponse<Category> createCategory(@RequestBody CategoryRequest categoryRequest) {
        Category category = categoryService.create(categoryRequest);
        return ApiResponse.<Category>builder()
                .result(category)
                .build();
    }

    public ApiResponse<List<CategoryResponse>> getAllCategories() {
        return ApiResponse.<List<CategoryResponse>>builder()
                .result(categoryService.getAll())
                .build();
    }

    public ApiResponse<CategoryResponse> getCategoryById(String id) {
        return ApiResponse.<CategoryResponse>builder()
                .result(categoryService.getById(id))
                .build();
    }

    public ApiResponse<Void> deleteCategory(String id) {
        categoryService.delete(id);
        return ApiResponse.<Void>builder().build();
    }
}
