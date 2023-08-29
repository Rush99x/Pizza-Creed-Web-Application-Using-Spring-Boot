package com.pizzacreed.service.impl;

import com.pizzacreed.model.Admin;
import com.pizzacreed.repository.AdminRepository;
import com.pizzacreed.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}