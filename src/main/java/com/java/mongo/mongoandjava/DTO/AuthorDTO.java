package com.java.mongo.mongoandjava.DTO;

import java.io.Serializable;

import com.java.mongo.mongoandjava.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO implements Serializable{
    
    private String id;
    private String name;

    public AuthorDTO(User user){
        
        id = user.getId();
        name = user.getName();

    }




}
