package com.Estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Estore.dto.reponse.ApiResponse;
import com.Estore.dto.reponse.OrderResponse;
import com.Estore.dto.request.OrderRequest;
import com.Estore.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping()
	public ApiResponse<OrderResponse> create(@RequestBody OrderRequest request)
	{
		var oder = orderService.create(request);
		return ApiResponse.<OrderResponse>builder()
				.result(oder)
				.build();
	}

	@GetMapping("/{id}")
	public ApiResponse<OrderResponse> getbyid(@PathVariable String id)
	{
		return ApiResponse.<OrderResponse>builder()
				.result(orderService.getOrderbyId(id))
				.build();
	}
}
