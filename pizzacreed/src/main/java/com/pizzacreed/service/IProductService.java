package com.pizzacreed.service;

import com.pizzacreed.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    void saveProduct(Product product);
    Product getProductById(long id);
    boolean deleteProductById(long id);
    Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


    List<Product> findAll();

    Product save(Product product);
}