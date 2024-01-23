package com.java.mongo.mongoandjava.DTO;

import java.io.Serializable;

import com.java.mongo.mongoandjava.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable{

    private String id;
    private String name;
    private String email;

    public UserDTO(User user){

        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    

        
    }


    
    
}
