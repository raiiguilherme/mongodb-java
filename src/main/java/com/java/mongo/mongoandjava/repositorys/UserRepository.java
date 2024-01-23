package com.java.mongo.mongoandjava.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.java.mongo.mongoandjava.domain.User;

@Repository //anotação que indica que essa interface é um repositorio 
public interface UserRepository extends MongoRepository<User, String>{
    
}
