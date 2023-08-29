package com.pizzacreed.service.impl;

import com.pizzacreed.model.Checkout;
import com.pizzacreed.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {
    @Autowired
    private CheckoutRepository checkoutRepository;
    public List<Checkout> listAll() {
        return checkoutRepository.findAll();
    }

    public void save(Checkout std) {
        checkoutRepository.save(std);
    }

    public Checkout get(long id) {
        return checkoutRepository.findById(id).get();
    }

    public void delete(long id) {
        checkoutRepository.deleteById(id);
    }

}