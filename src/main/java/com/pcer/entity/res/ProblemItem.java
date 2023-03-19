package com.pcer.entity.res;

import com.pcer.entity.Tag;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ProblemItem {
    Integer id;
    String name;
    String difficulty;
    String content;
    ArrayList<Tag> tags;
}
