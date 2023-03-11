package com.pcer.entity.res;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ProblemItem {
    Integer id;
    String name;
    String difficulty;
    String content;
    ArrayList<String> tags;

}
