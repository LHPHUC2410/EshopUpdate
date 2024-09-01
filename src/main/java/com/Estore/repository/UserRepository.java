package com.Estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estore.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
