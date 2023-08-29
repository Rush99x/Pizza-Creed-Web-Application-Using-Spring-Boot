package com.pizzacreed.service.impl;

import com.pizzacreed.model.User;
import com.pizzacreed.repository.UserRepository;
import com.pizzacreed.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User save(User user) {
        User dao=null;
        if(user.getId() == null){
            dao = new User();
        }
        else {
            Optional<User> optionalUser = userRepository.findById(user.getId());
            if (optionalUser.isPresent()){
                dao = optionalUser.get();
            }
        }
        BeanUtils.copyProperties(user,dao);
        dao = userRepository.save(dao);
        user.setId(dao.getId());
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(s ->{
            User dto =new User();
            BeanUtils.copyProperties(s,dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public User find(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User dto =new User();
            BeanUtils.copyProperties(optionalUser.get(),dto);
            return dto;
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<com.pizzacreed.model.User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            userRepository.delete(optionalUser.get());
        }else {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;

}
}