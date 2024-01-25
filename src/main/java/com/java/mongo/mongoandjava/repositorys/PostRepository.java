package com.java.mongo.mongoandjava.repositorys;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.mongo.mongoandjava.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    //para mais informações:https://www.mongodb.com/docs/manual/reference/operator/query/regex/
    //title: campo que deseja realizar a busca
    //?0: indica que é o primeiro parametro que vai definir a busca, no caso, o String text
    //i: significa que vai ignorar as letras maiusculas
    @Query(" {'title': { $regex: ?0, $options: 'i' } } ")
    List<Post> findByTitle(String text);



    //muito importante respeitar os nomes para que de certo
    //camalCase!!
     List<Post> findByTitleContainingIgnoreCase(String text); //para procurar posts que tenham esse mesmo titulo

    //busca com varios criterios 
    //$and: operador E
    //?1: campo que sera comparado
     @Query("{ $and: [ { date: { $gte: ?1 } } , { date: { $lte: ?2 } } , { $or: [ {'title': { $regex: ?0, $options: 'i' }}, {'body': { $regex: ?0, $options: 'i' }},{'comments.text': { $regex: ?0, $options: 'i' }} ] } ] }")   
     List<Post> fullSearch(String text, Date min, Date max);

    
} 
    

