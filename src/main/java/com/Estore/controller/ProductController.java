package com.Estore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Estore.dto.reponse.ApiResponse;
import com.Estore.dto.reponse.ProductResponse;
import com.Estore.dto.request.ProductRequest;
import com.Estore.entity.Product;
import com.Estore.service.ProductService;

//@Controller
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	
	@GetMapping()
	public ApiResponse<List<ProductResponse>> getAllProduct() 
	{
		return ApiResponse.<List<ProductResponse>>builder()
				.result(productService.getAll())
				.build();
	}
	
	@PostMapping()
	public ApiResponse<Product> createProduct(@RequestBody ProductRequest request)
	{
		Product product = productService.create(request);
		
		return ApiResponse.<Product>builder()
				.result(product)
				.build();
	}
	
	@PutMapping("/{id}")
	public ApiResponse<ProductResponse> updateProduct(@PathVariable String id,
			@RequestBody ProductRequest request)
	{
		ProductResponse product = productService.updateProduct(id, request);
		
		return ApiResponse.<ProductResponse>builder()
				.result(product)
				.build();
	}
	
	@DeleteMapping("/{id}")
	public ApiResponse<Void> deleteProduct(@PathVariable String id)
	{
		productService.delete(id);
		return ApiResponse.<Void>builder().build();
	}
	
	@GetMapping("/{id}")
	public ApiResponse<ProductResponse> getProduct(@PathVariable String id)
	{
		
		return ApiResponse.<ProductResponse>builder()
				.result(productService.getProduct(id))
				.build();
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "index";
	}
}
