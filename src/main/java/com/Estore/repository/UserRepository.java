package com.Estore.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Estore.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
