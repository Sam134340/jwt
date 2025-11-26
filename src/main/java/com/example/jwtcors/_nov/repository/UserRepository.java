package com.example.jwtcors._nov.repository;

import com.example.jwtcors._nov.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
