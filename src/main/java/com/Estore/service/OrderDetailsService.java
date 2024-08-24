package com.Estore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estore.dto.reponse.OrderDetailsResponse;
import com.Estore.dto.request.OrderDetailsRequest;
import com.Estore.entity.OrderDetails;
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
		
		var order = orderRepository.findById(request.getOrder_id()).orElse(null);

		
		var product = productRepository.findById(request.getProduct_id()).orElseThrow(() -> new RuntimeException("Product not found"));
		
		oDetails.setOrder(order);
		oDetails.setProduct(product);
		
		orderDetailsRepositiory.save(oDetails);
		
		orderDetailsResponse.setId(oDetails.getId());
		
		//orderDetailsResponse.setOrder_id(order.getId());
		if(order == null) {
			orderDetailsResponse.setOrder_id("none");
		} else {
			orderDetailsResponse.setOrder_id(order.getId());
		}

		orderDetailsResponse.setProduct_name(product.getName());
		
		return orderDetailsResponse;
	}

	public void delete(String id) {
		orderDetailsRepositiory.deleteById(id);
	}

	public OrderDetailsResponse update(String id, OrderDetailsRequest request) {
		OrderDetails details = orderDetailsRepositiory.findById(id).orElseThrow(() -> new RuntimeException("OrderDetails not found"));
		details.setQuantity(request.getQuantity());
		var order = orderRepository.findById(request.getOrder_id()).orElse(null);
		var product = productRepository.findById(request.getProduct_id()).orElseThrow(() -> new RuntimeException("Product not found"));
		
		details.setOrder(order);
		details.setProduct(product);

		OrderDetailsResponse result = orderDetailsMapper.toOrderDetailsResponse(details);
		if(order == null) {
			result.setOrder_id("none");
		} else 
		{
			result.setOrder_id(order.getId());
		}
		result.setProduct_name(product.getName());

		orderDetailsRepositiory.save(details);
		return result;
	}

	public List<OrderDetailsResponse> getAll()
	{
		var list = orderDetailsRepositiory.findAll();
		List<OrderDetailsResponse> result = new ArrayList<OrderDetailsResponse>();
		for (OrderDetails orderDetails : list) {
			OrderDetailsResponse temp = orderDetailsMapper.toOrderDetailsResponse(orderDetails);
			if (orderDetails.getOrder() == null) {
				temp.setOrder_id("none");
			} else
			{
				temp.setOrder_id(orderDetails.getOrder().getId());
			}
			//temp.setOrder_id(orderDetails.getOrder().getId());
			temp.setProduct_name(orderDetails.getProduct().getName());
			result.add(temp);
		}
		return result;
	}
}
