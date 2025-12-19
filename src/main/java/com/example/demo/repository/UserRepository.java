package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ✅ REQUIRED by tests
    boolean existsByEmail(String email);

    // ✅ REQUIRED by tests
    Optional<User> findByEmail(String email);
}
