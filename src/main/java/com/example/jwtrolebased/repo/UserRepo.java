package com.example.jwtrolebased.repo;

import com.example.jwtrolebased.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String s);
}
