package com.pizzacreed.controller;

import com.pizzacreed.model.Product;
import com.pizzacreed.model.User;
import com.pizzacreed.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    IProductService iProductService;
    @RequestMapping(value = "/product",method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProduct(){
        return iProductService.findAll();
    }

    @RequestMapping(value = "/product",method = RequestMethod.POST)
    @ResponseBody
    public Product createProduct(@RequestBody Product product){
        return iProductService.save(product);
    }

    @RequestMapping(value = "/product/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Product UpdateProduct(@PathVariable Long id,@RequestBody Product product){
        product.setId(id);
        return iProductService.save(product);
    }
    @RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteProduct(@PathVariable Long id){
        return iProductService.deleteProductById(id);
    }
}
