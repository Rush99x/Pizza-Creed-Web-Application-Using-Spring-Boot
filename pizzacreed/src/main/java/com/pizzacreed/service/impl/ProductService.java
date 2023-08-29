package com.pizzacreed.service.impl;

import com.pizzacreed.model.Product;
import com.pizzacreed.repository.ProductRepository;
import com.pizzacreed.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }
    @Override
    public Product getProductById(long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id :: " + id);
        }
        return product;
    }
    @Override
    public boolean deleteProductById(long id) {
        this.productRepository.deleteById(id);
        return false;
    }

    @Override
    public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(s ->{
            Product dto = new Product();
            BeanUtils.copyProperties(s,dto);
            return dto;
        }).collect(Collectors.toList());
    }



    @Override
    public Product save(Product product) {
       Product dao = null;
        if(product.getId() == null ){
            dao = new Product();
        }
        else {
            Optional<Product> optionalProduct = productRepository.findById(product.getId());
            if(optionalProduct.isPresent()){
                dao = optionalProduct.get();
            }
        }
        BeanUtils.copyProperties(product,dao);
        dao = productRepository.save(dao);
        product.setId(dao.getId());
        return product;
    }


}


