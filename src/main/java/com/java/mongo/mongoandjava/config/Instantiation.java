package com.java.mongo.mongoandjava.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.java.mongo.mongoandjava.DTO.AuthorDTO;
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




        Post post1 = new Post(null,sss.parse("11/11/1111"), "Bom dia!",
         "hoje acordei daquele jeito!", new AuthorDTO(bob));//passando as informações do usuario para o userDTO para que haja mais segurança
        postRepository.save(post1);

        bob.getPosts().add(post1);
        repository.save(bob);

    }
    
}
