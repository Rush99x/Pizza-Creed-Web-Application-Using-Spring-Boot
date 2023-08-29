package com.pizzacreed.repository;

import com.pizzacreed.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}