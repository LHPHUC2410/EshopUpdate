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
		
		var order = orderRepository.findById(request.getOrder_id()).orElseThrow(() -> new RuntimeException("Order not found"));
		
		var product = productRepository.findById(request.getProduct_id()).orElseThrow(() -> new RuntimeException("Order not found"));
		
		oDetails.setOrder(order);
		oDetails.setProduct(product);
		
		orderDetailsRepositiory.save(oDetails);
		
		orderDetailsResponse.setId(oDetails.getId());
		orderDetailsResponse.setOrder_id(order.getId());
		orderDetailsResponse.setProduct_name(product.getName());
		
		return orderDetailsResponse;
	}
}
