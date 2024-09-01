package com.Estore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.Estore.dto.reponse.ProductResponse;
import com.Estore.dto.request.ProductRequest;
import com.Estore.entity.Product;


@Mapper(componentModel = "Spring")
public interface ProductMapper {
	Product toProduct (ProductRequest request);
	
	
	ProductResponse toProductResponse(Product request);
	
	void updateProduct(@MappingTarget Product product,ProductRequest request);
}
