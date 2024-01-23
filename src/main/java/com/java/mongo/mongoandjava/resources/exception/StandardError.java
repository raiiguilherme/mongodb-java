package com.java.mongo.mongoandjava.resources.exception;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable{

    private Instant timestamp;
    private Integer status;
    private String message;
    private String error;
    private String path;

    
}
