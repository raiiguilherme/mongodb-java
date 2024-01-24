package com.java.mongo.mongoandjava.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.mongo.mongoandjava.domain.Post;
import com.java.mongo.mongoandjava.resources.URL.URL;
import com.java.mongo.mongoandjava.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){

       Post pos = service.FindById(id);
       return ResponseEntity.ok(pos);


    }

    @GetMapping(value = "/searchtitle")//caminho da URL, colocar um "?" logo apos ele para respeitar o padrão HTTP

    //ResquestParam(para indicar que o String text não sera passado por parametro da URL (Exemplo: "/{text}"))
    //value = "text", para o endpoint identificar o nome do paramentro exemplo: /searchtitle?text=noite
    //defaultValue: para que se o parametro text não for informado, sera atribuido a ele uma String vazia
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){

        URL.decodeParam(text); //decodificando o parametro
        List<Post> list = service.FindByTittle(text);
        return ResponseEntity.ok(list);

    }

    
}
