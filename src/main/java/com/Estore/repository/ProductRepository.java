package com.Estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estore.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
