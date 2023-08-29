package com.pizzacreed.controller;

import com.pizzacreed.dto.OrderRequest;
import com.pizzacreed.dto.OrderResponse;
import com.pizzacreed.model.Customer;
import com.pizzacreed.model.Pizza;
import com.pizzacreed.repository.CustomerRepository;
import com.pizzacreed.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request) {
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders() {
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation() {
        return customerRepository.getJoinInformation();
    }

//    @PutMapping("/updateOrder/{id}")
//    public Customer updateOrder(@PathVariable int id, @RequestBody OrderRequest request) {
//        return customerRepository.findById(id)
//                .map(customer -> {
//                    customer.setName(request.getCustomer().getName());
//                    customer.setEmail(request.getCustomer().getEmail());
//                    customer.setGender(request.getCustomer().getGender());
//                    // Update other customer properties as needed
//                    return customerRepository.save(customer);
//                })
//                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
//    }
//
//    @DeleteMapping("/deleteOrder/{id}")
//    public ResponseEntity<?> deleteOrder(@PathVariable int id) {
//        return customerRepository.findById(id)
//                .map(customer -> {
//                    customerRepository.delete(customer);
//                    return ResponseEntity.ok().build();
//                })
//                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        @PutMapping("/updatePizza/{pizzaId}")
        public Pizza updatePizza(@PathVariable int pizzaId, @RequestBody Pizza pizza) {
            return pizzaRepository.findById(pizzaId)
                    .map(existingPizza -> {
                        existingPizza.setPizzaName(pizza.getPizzaName());
                        existingPizza.setQty(pizza.getQty());
                        existingPizza.setPrice(pizza.getPrice());
                        // Update other pizza properties as needed
                        return pizzaRepository.save(existingPizza);
                    })
                    .orElseThrow(() -> new RuntimeException("Pizza not found with id: " + pizzaId));
        }

        @DeleteMapping("/deletePizza/{pizzaId}")
        public ResponseEntity<?> deletePizza(@PathVariable int pizzaId) {
            return pizzaRepository.findById(pizzaId)
                    .map(existingPizza -> {
                        pizzaRepository.delete(existingPizza);
                        return ResponseEntity.ok().build();
                    })
                    .orElseThrow(() -> new RuntimeException("Pizza not found with id: " + pizzaId));
        }
    }

