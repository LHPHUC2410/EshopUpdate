package com.Estore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estore.dto.reponse.OrderDetailsResponse;
import com.Estore.dto.reponse.OrderResponse;
import com.Estore.dto.request.OrderRequest;
import com.Estore.entity.Orders;
import com.Estore.mapper.OrderDetailsMapper;
import com.Estore.mapper.OrderMapper;
import com.Estore.mapper.ProductMapper;
import com.Estore.repository.OrderDetailsRepositiory;
import com.Estore.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailsRepositiory orderDetailsRepositiory;
	
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderDetailsMapper orderDetailsMapper;
	
	public OrderResponse create(OrderRequest request)
	{
		Orders order = new Orders();
		order.setOrderDate(request.getOrderDate());
		orderRepository.save(order);
		OrderResponse result = new OrderResponse();
		result = orderMapper.toOrderResponse(order);
		for (String s : request.getOrderdetails_ids()) {
			var p = orderDetailsRepositiory.findById(s).orElseThrow(() -> new RuntimeException("OrderDetails not found"));
			OrderDetailsResponse orderResponse = new OrderDetailsResponse();
			orderResponse.setProduct_name(p.getProduct().getName());
			orderResponse.setQuantity(p.getQuantity());
			result.getOrderDetailsResponses().add(orderResponse);
		}
		return result;
	}
}
