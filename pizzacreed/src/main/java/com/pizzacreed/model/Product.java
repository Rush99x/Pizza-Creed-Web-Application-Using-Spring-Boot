package com.pizzacreed.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @NotBlank Long id;
    @Column(name = "name")
    private @NotBlank String name;
    @Column(name = "flavor")
    private @NotBlank String flavor;
    @Column(name = "size")
    private @NotBlank String size;
    @Column(name = "description")
    private @NotBlank String description;
    @Column(name = "price")
    private @NotBlank String price;

//    @OneToMany(mappedBy = "product")
//    private List<Basketitem> basketitems;
//
//    public List<Basketitem> getBasketitems() {
//        return basketitems;
//    }
//
//    public void setBasketitems(List<Basketitem> basketitems) {
//        this.basketitems = basketitems;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
