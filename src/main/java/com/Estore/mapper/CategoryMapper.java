package com.Estore.mapper;

import com.Estore.dto.reponse.CategoryResponse;
import com.Estore.dto.request.CategoryRequest;
import com.Estore.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequest categoryRequest);

    CategoryResponse toCategoryResponse(Category category);
}
