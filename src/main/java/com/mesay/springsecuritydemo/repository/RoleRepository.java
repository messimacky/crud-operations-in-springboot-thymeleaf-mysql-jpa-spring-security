package com.mesay.springsecuritydemo.repository;

import com.mesay.springsecuritydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
