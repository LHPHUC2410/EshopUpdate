package com.Estore.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estore.dto.reponse.OrderDetailsResponse;
import com.Estore.dto.reponse.OrderResponse;
import com.Estore.dto.request.OrderRequest;
import com.Estore.entity.OrderDetails;
import com.Estore.entity.Orders;
import com.Estore.mapper.OrderDetailsMapper;
import com.Estore.mapper.OrderMapper;
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
	private OrderDetailsMapper detailsMapper;
	
	public OrderResponse create(OrderRequest request)
	{
		Orders order = new Orders();
		order.setOrderDate(request.getOrderDate());
		orderRepository.save(order);
		OrderResponse result = new OrderResponse();
	
		result = orderMapper.toOrderResponse(order);
		result.setOrderDetailsResponses(new HashSet<>());
		for (String s : request.getOrderdetails_ids()) {
			var p = orderDetailsRepositiory.findById(s).orElseThrow(() -> new RuntimeException("OrderDetails not found"));
			if(p.getOrder() == null) {
				p.setOrder(order);
				orderDetailsRepositiory.save(p);
				OrderDetailsResponse orderResponse = new OrderDetailsResponse();
				orderResponse.setProduct_name(p.getProduct().getName());
				orderResponse.setQuantity(p.getQuantity());
				result.getOrderDetailsResponses().add(orderResponse);
			} else {
				System.out.println("OrderDetails already exists in Order");
			}

			// OrderDetailsResponse orderResponse = new OrderDetailsResponse();
			// orderResponse.setProduct_name(p.getProduct().getName());
			// orderResponse.setQuantity(p.getQuantity());
			// result.getOrderDetailsResponses().add(orderResponse);
		}
		return result;
	}

	public OrderResponse getOrderbyId(String id) {
		Orders order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
		OrderResponse result  = orderMapper.toOrderResponse(order);
		Set<OrderDetailsResponse> listDetailsResponses = new HashSet<>();
		for (OrderDetails orderDetail : order.getListorderDetails()) {
			OrderDetailsResponse temp = new OrderDetailsResponse();
			temp = detailsMapper.toOrderDetailsResponse(orderDetail);
			temp.setOrder_id(orderDetail.getOrder().getId());
			temp.setProduct_name(orderDetail.getProduct().getName());
			listDetailsResponses.add(temp);
		}
		result.setOrderDetailsResponses(listDetailsResponses);
		return result;
	}
}
