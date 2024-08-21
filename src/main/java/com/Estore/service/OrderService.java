package com.Estore.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estore.dto.reponse.OrderResponse;
import com.Estore.dto.request.OrderRequest;
import com.Estore.entity.Orders;
import com.Estore.entity.Product;
import com.Estore.mapper.OrderMapper;
import com.Estore.repository.OrderRepository;
import com.Estore.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderMapper orderMapper;
	
//	public OrderResponse create(OrderRequest request)
//	{
//		//Orders order = orderMapper.toOrders(request);
//		orderRepository.save(order);
//		Set<Product> products = new HashSet<Product>(productRepository.findAllById(request.getProduct_ids()));
//		//order.setProducts(products);
//		return orderMapper.toOrderResponse(order);
//	}
}
