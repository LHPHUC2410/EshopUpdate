package com.Estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estore.entity.OrderDetails;

public interface OrderDetailsRepositiory extends JpaRepository<OrderDetails, String>{

}
