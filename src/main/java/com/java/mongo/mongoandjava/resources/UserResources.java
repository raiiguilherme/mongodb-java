package com.java.mongo.mongoandjava.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.mongo.mongoandjava.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {


    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        User maria = new User("1","maria Silva" , "maria@gmail.com");
        User pedro = new User("2", "pedro", "pedro@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, pedro));
        return ResponseEntity.ok(list);
    }

    
}
