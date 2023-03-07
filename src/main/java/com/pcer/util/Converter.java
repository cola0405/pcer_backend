package com.pcer.util;

import org.springframework.stereotype.Component;

@Component
public class Converter {
    public String [] d = {"简单","中等","困难"};

    public String getDifficulty(String difficulty){
        return d[Integer.parseInt(difficulty)];
    }
}
