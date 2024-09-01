package com.Estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estore.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
