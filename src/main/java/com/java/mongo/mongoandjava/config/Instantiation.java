package com.java.mongo.mongoandjava.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.java.mongo.mongoandjava.DTO.AuthorDTO;
import com.java.mongo.mongoandjava.DTO.CommentDTO;
import com.java.mongo.mongoandjava.domain.Post;
import com.java.mongo.mongoandjava.domain.User;
import com.java.mongo.mongoandjava.repositorys.PostRepository;
import com.java.mongo.mongoandjava.repositorys.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    SimpleDateFormat sss = new SimpleDateFormat("dd/MM/yyyy");
   
    @Autowired
    private PostRepository postRepository;
       

    @Autowired
    private UserRepository repository;


    @Override
    public void run(String... args) throws Exception {
        
        repository.deleteAll();
        postRepository.deleteAll();//deleta todos quando inicia a aplicação!!
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");


        
        repository.saveAll(Arrays.asList(maria,alex,bob));




        Post post1 = new Post(null,sss.parse("11/11/2022"), "Bom dia!",
         "hoje acordei daquele jeito!", new AuthorDTO(bob));//passando as informações do usuario para o userDTO para que haja mais segurança
       

         Post post2 = new Post(null,sss.parse("11/11/2023"), "Noite Legal",
         "hoje irei dormir cedo", new AuthorDTO(maria));



        CommentDTO comment = new CommentDTO("bom diaaa", sss.parse("10/12/2018"),new AuthorDTO(maria));


            post1.getComments().add(comment); //associando um comentario com um post
            postRepository.saveAll(Arrays.asList(post1, post2));

        bob.getPosts().add(post1);
        repository.save(bob);

    }
    
}
