package com.Estore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estore.dto.reponse.OrderDetailsResponse;
import com.Estore.dto.request.OrderDetailsRequest;
import com.Estore.mapper.OrderDetailsMapper;
import com.Estore.repository.OrderDetailsRepositiory;
import com.Estore.repository.OrderRepository;
import com.Estore.repository.ProductRepository;

@Service
public class OrderDetailsService {
	@Autowired
	private OrderDetailsRepositiory orderDetailsRepositiory;
	
	@Autowired
	private OrderDetailsMapper orderDetailsMapper;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public OrderDetailsResponse create(OrderDetailsRequest request) {
		var oDetails = orderDetailsMapper.toOrderDetails(request);
		
		var orderDetailsResponse = orderDetailsMapper.toOrderDetailsResponse(oDetails);
		
		var orderId = orderRepository.findById(request.getOrder_id()).orElseThrow(() -> new RuntimeException("Order not found")).getId();
		
		var productName = productRepository.findById(request.getProduct_id()).orElseThrow(() -> new RuntimeException("Order not found")).getName();
		
		orderDetailsResponse.setOrder_id(orderId);
		
		orderDetailsResponse.setProduct_name(productName);
		
		return orderDetailsResponse;
	}
}
