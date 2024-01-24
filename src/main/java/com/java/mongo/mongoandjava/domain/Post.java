package com.java.mongo.mongoandjava.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.java.mongo.mongoandjava.DTO.AuthorDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Document(value = "post")
public class Post {
    
    @Id
    private String id;

    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;
}
