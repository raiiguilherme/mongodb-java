package com.java.mongo.mongoandjava.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.mongo.mongoandjava.DTO.UserDTO;
import com.java.mongo.mongoandjava.domain.User;
import com.java.mongo.mongoandjava.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {


    @Autowired
    private UserService service;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){

        List<User> list = service.findAll();
        //transformando a lista de User em uma nova lista de DTO utilizando expressoes lambda
        List<UserDTO> lisdto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok(lisdto);
    }

    
}
