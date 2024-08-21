package com.Estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
//	@PostMapping()
//	public ApiResponse<OrderResponse> create(@RequestBody OrderRequest request)
//	{
//		var oder = orderService.create(request);
//		return ApiResponse.<OrderResponse>builder()
//				.result(oder)
//				.build();
//	}
}
