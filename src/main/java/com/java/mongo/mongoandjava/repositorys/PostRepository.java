package com.java.mongo.mongoandjava.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.java.mongo.mongoandjava.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    
} 
    

