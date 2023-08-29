package com.pizzacreed.controller;

import com.pizzacreed.model.Checkout;
import com.pizzacreed.service.impl.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/checkout")
    public String viewHomePage(Model model) {
        List<Checkout> listcheckout = checkoutService.listAll();
        model.addAttribute("listcheckout", listcheckout);
        System.out.print("Get / ");
        return "checkout";
    }

    @GetMapping("/new_checkout")
    public String add(Model model) {
        model.addAttribute("checkout", new Checkout());
        return "new_checkout";
    }

    @RequestMapping(value = "/saves", method = RequestMethod.POST)
    public String saveCheckout(@ModelAttribute("checkout") Checkout std) {
        checkoutService.save(std);
        return "redirect:/";
    }

    @RequestMapping("/edits/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new_checkout");
        Checkout std = checkoutService.get(id);
        mav.addObject("checkout", std);
        return mav;

    }
    @RequestMapping("/deletes/{id}")
    public String deletecheckout(@PathVariable(name = "id") int id) {
        checkoutService.delete(id);
        return "redirect:/";
    }
}

