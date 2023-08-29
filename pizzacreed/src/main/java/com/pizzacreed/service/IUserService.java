package com.pizzacreed.service;


import com.pizzacreed.model.User;

import java.util.List;

public interface IUserService {
   
    List<User> findAll();

    User find(Long id);

    boolean delete(Long id);

    User save(User user);
}
