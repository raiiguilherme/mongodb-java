package com.java.mongo.mongoandjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mongo.mongoandjava.domain.Post;
import com.java.mongo.mongoandjava.repositorys.PostRepository;

@Service
public class PostService {


    @Autowired
    private PostRepository repository;


    
    public Post FindById(String id){
       Optional<Post> op = repository.findById(id);
       return op.get();


    }

    public List<Post> FindByTittle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }
    
}
