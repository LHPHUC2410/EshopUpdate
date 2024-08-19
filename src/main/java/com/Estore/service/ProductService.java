package com.Estore.service;

import java.util.ArrayList;
import java.util.List;

import com.Estore.entity.Category;
import com.Estore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estore.dto.reponse.ProductResponse;
import com.Estore.dto.request.ProductRequest;
import com.Estore.entity.Product;
import com.Estore.mapper.ProductMapper;
import com.Estore.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper productMapper;

	@Autowired
	CategoryRepository categoryRepository;
	
	public Product create(ProductRequest request)
	{
		Product product =  productMapper.toProduct(request);
		Category category = categoryRepository.findById(request.getCategory_id()).orElseThrow(() -> new RuntimeException("Category not found"));
		product.setCategory(category);
		return productRepository.save(product);
	}
	
	public List<ProductResponse> getAll() 
	{
		List<ProductResponse> list = new ArrayList<ProductResponse>();
		list = productRepository.findAll().stream().map(productMapper::toProductResponse).toList();
		return list;
	}
	
	public ProductResponse getProduct(String id)
	{
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		return productMapper.toProductResponse(product); 
	}
	
	public ProductResponse updateProduct(String id, ProductRequest request)
	{
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		productMapper.updateProduct(product, request);
		return productMapper.toProductResponse(productRepository.save(product)); 
	}
	
	public void delete(String id)
	{
		productRepository.deleteById(id);
	}
}
