package com.Estore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.Estore.dto.reponse.ProductResponse;
import com.Estore.dto.request.ProductRequest;
import com.Estore.entity.Product;


@Mapper(componentModel = "Spring")
public interface ProductMapper {
	@Mapping(target = "category", ignore = true)
	Product toProduct (ProductRequest request);
	
	ProductResponse toProductResponse(Product request);
	
	@Mapping(target = "category", ignore = true)
	void updateProduct(@MappingTarget Product product,ProductRequest request);
}
