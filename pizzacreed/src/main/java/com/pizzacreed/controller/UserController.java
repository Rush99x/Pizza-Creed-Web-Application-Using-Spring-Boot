package com.pizzacreed.controller;


import com.pizzacreed.model.User;
import com.pizzacreed.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    IUserService service;

//    @GetMapping
//    @RequestMapping(value = "/users",method = RequestMethod.GET)
//    @ResponseBody
//    public List<User> getUsers(){return service.findAll();}

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user)
    {
        service.save(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}