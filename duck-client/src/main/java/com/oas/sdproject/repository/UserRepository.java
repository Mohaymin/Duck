package com.oas.sdproject.repository;

import com.oas.sdproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query method for login
    Optional<User> findByEmail(String username);
}