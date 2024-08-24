package com.Estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Estore.dto.reponse.ApiResponse;
import com.Estore.dto.reponse.OrderDetailsResponse;
import com.Estore.dto.request.OrderDetailsRequest;
import com.Estore.service.OrderDetailsService;

@RestController
@RequestMapping("/order_details")
public class OrderDetailsController {
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@PostMapping()
	public ApiResponse<OrderDetailsResponse> create (@RequestBody OrderDetailsRequest request)
	{
		return ApiResponse.<OrderDetailsResponse>builder()
				.result(orderDetailsService.create(request))
				.build();
	}

	@PutMapping("/{id}")
	public ApiResponse<OrderDetailsResponse> update (@PathVariable String id ,@RequestBody OrderDetailsRequest request)
	{
		return ApiResponse.<OrderDetailsResponse>builder()
				.result(orderDetailsService.update(id, request))
				.build();
	}
}
