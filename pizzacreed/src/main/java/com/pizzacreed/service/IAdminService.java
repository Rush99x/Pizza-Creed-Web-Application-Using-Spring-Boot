package com.pizzacreed.service;

import com.pizzacreed.model.Admin;

public interface IAdminService { Admin findByUsername(String username);
}