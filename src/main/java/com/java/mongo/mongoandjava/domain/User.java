package com.java.mongo.mongoandjava.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;



@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document (collection = "user") //indica ao spring que essa classe é uma "entidade" no nosso MongoDB
public class User implements Serializable{

    @Id
    private String id;
    private String name;
    private String email;
    @DBRef(lazy = true) //para que a lista não seja carregada em uma simples chamada do usuario, apenas numa chamada explícita
    private List<Post> posts = new ArrayList<>();

   
   //getters e setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Post> getPosts() {
        return posts;
    }
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    

    




    
    
}
