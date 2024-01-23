package com.java.mongo.mongoandjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mongo.mongoandjava.domain.User;
import com.java.mongo.mongoandjava.repositorys.UserRepository;
import com.java.mongo.mongoandjava.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        List<User> list = repository.findAll();
        return list;
    }


    public User findById(String id){

        Optional<User> us = repository.findById(id);
        return us.orElseThrow(() -> new ObjectNotFoundException("objeto nao encontrado"));

    }
    
}
