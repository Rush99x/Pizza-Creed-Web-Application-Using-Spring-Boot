package com.pizzacreed.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "checkout")
public class Checkout {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CusName")
    private @NotBlank String CusName;
    @Column(name = "CusNumber")
    private @NotBlank String CusNumber;
    @Column(name = "Payment")
    private @NotBlank String Payment;
    @Column(name = "Address")
    private @NotBlank String Address;
    @Column(name = "PizzaId")
    private @NotBlank String PizzaId;
    @Column(name = "PizzaQty")
    private @NotBlank String PizzaQty;

    public Checkout(){
        this.id=id;
        this.CusName=CusName;
        this.CusNumber=CusNumber;
        this.Payment=Payment;
        this.Address=Address;
        this.PizzaId=PizzaId;
        this.PizzaQty=PizzaQty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    public String getCusNumber() {
        return CusNumber;
    }

    public void setCusNumber(String cusNumber) {
        CusNumber = cusNumber;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String payment) {
        Payment = payment;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPizzaId() {
        return PizzaId;
    }

    public void setPizzaId(String pizzaId) {
        PizzaId = pizzaId;
    }

    public String getPizzaQty() {
        return PizzaQty;
    }

    public void setPizzaQty(String pizzaQty) {
        PizzaQty = pizzaQty;
    }
}
