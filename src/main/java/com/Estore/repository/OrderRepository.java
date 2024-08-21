package com.Estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estore.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, String> {

}
