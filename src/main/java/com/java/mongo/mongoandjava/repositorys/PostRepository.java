package com.java.mongo.mongoandjava.repositorys;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.java.mongo.mongoandjava.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    //muito importante respeitar os nomes para que de certo
    //camalCase!!
     List<Post> findByTitleContainingIgnoreCase(String text); //para procurar posts que tenham esse mesmo titulo

    
} 
    

