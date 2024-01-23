package com.java.mongo.mongoandjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mongo.mongoandjava.DTO.UserDTO;
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

    public User insert(User user){//inserindo no banco de dados
        return repository.insert(user);
    }

    public User fromDTO( UserDTO userDto){//tranformando um UserDTO e User
    return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }

    public void deleteById(String id){
        findById(id);
        repository.deleteById(id);
    }
    
}
