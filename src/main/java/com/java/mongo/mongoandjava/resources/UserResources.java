package com.java.mongo.mongoandjava.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){

        User us = service.findById(id);
        return ResponseEntity.ok(new UserDTO(us)); //transformando o user em UserDTO
        
        
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){

        User user = service.fromDTO(userDTO);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")//retornando o cabeçalho do caminho do novo usuario criado
        .buildAndExpand(user.getId()).toUri();//...
        
        return ResponseEntity.created(uri).build();



    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();//retorna o codigo 204

    }

    @PutMapping(value = "/alter/{id}")
    public ResponseEntity<Void> alter(@RequestBody UserDTO userDTO, @PathVariable String id){
        User user = service.fromDTO(userDTO); //passando o userDTO para user (Segurança de dados)
        user.setId(id);//para garantir que o objeto tenha o mesmo ID que a requisição
        service.update(user);
        return ResponseEntity.noContent().build();





    }

    
}
