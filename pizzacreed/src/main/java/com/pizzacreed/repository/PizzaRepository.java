package com.pizzacreed.repository;

import com.pizzacreed.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
    // New method for deleting a pizza
    void deleteById(int pizzaId);
    @Modifying
    @Query("UPDATE Pizza p SET p.pizzaName = :pizzaName, p.qty = :qty, p.price = :price WHERE p.id = :pizzaId")
    void updatePizza(@Param("pizzaId") Long pizzaId, @Param("pizzaName") String pizzaName, @Param("qty") int qty, @Param("price") int price);

}
