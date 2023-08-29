package com.pizzacreed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String showHomePage() {
    return "index";
}

    @RequestMapping("/index")
    public String SendToHomePage() {
        return "index";
    }

//    @GetMapping("/login")
//    public String showLoginPage() {
//        return "login";
//    }

    @GetMapping("/userRegistration")
    public String showRegistrationPage() {
        return "userRegistration";
    }

    @GetMapping("/ForgottenPassword")
    public String showForgottenPasswordPage() {
        return "ForgottenPassword";
    }

    @GetMapping("/Admin")
    public String showAdminPage() {
        return "Admin";
    }

    @GetMapping("/all")
    public String showallPage() {
        return "all";
    }

//    @GetMapping("/checkout")
//    public String showcheckoutPage() {
//        return "checkout";
//    }


//    @GetMapping("/cart")
//    public String showocartPage() {
//        return "cart";
//    }

//    @GetMapping("/product")
//    public String showoproductPage() {
//        return "product";
//    }
}