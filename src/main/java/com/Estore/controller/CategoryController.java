package com.Estore.controller;

import com.Estore.dto.reponse.ApiResponse;
import com.Estore.dto.reponse.CategoryResponse;
import com.Estore.dto.request.CategoryRequest;
import com.Estore.entity.Category;
import com.Estore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public ApiResponse<Category> createCategory(@RequestBody CategoryRequest categoryRequest) {
        Category category = categoryService.create(categoryRequest);
        return ApiResponse.<Category>builder()
                .result(category)
                .build();
    }

    @GetMapping()
    public ApiResponse<List<CategoryResponse>> getAllCategories() {
        return ApiResponse.<List<CategoryResponse>>builder()
                .result(categoryService.getAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<CategoryResponse> getCategoryById(@PathVariable String id) {
        return ApiResponse.<CategoryResponse>builder()
                .result(categoryService.getById(id))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteCategory(@PathVariable String id) {
        categoryService.delete(id);
        return ApiResponse.<Void>builder().build();
    }
}
