package com.pizzacreed.repository;

import com.pizzacreed.dto.OrderResponse;
import com.pizzacreed.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("SELECT new com.pizzacreed.dto.OrderResponse(c.name , p.pizzaName) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();

    // New method for updating a customer
    @Modifying
    @Query("UPDATE Customer c SET c.name = :name, c.email = :email, c.gender = :gender WHERE c.id = :customerId")
    void updateCustomer(@Param("customerId") Long customerId, @Param("name") String name, @Param("email") String email, @Param("gender") String gender);

}
