package com.java.mongo.mongoandjava.resources.URL;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {


    public static String decodeParam(String text){
        try {//decodificando o texto que vem por parametro
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
           return "";
        }
    }
    
}
