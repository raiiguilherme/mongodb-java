package com.java.mongo.mongoandjava.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Document (collection = "user") //indica ao spring que essa classe é uma "entidade" no nosso MongoDB
public class User implements Serializable{

    @Id
    private String id;
    private String name;
    private String email;


    
}
