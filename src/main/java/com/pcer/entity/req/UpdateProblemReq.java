package com.pcer.entity.req;

import com.pcer.entity.Tag;
import lombok.Data;

import java.util.ArrayList;

@Data
public class UpdateProblemReq {
    Integer id;
    String name;
    String difficulty;
    String content;
    ArrayList<String> selectedTags;
}
