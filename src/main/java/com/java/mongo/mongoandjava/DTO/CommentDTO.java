package com.java.mongo.mongoandjava.DTO;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO implements Serializable{

    private String text;
    private Date data;
    private AuthorDTO author;

    
}
