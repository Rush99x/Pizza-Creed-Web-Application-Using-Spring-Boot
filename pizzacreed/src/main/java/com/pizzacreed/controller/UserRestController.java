package com.pizzacreed.controller;


import com.pizzacreed.model.User;
import com.pizzacreed.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    IUserService service;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(){
        return service.findAll();
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody User user){
        return service.save(user);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public User UpdateUser(@PathVariable Long id,@RequestBody User user){
        user.setId(id);
        return service.save(user);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User findUser(@PathVariable Long id){
        return service.find(id);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteUser(@PathVariable Long id){
        return service.delete(id);
}
}