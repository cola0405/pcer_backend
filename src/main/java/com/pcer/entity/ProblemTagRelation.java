package com.pcer.entity;

import lombok.Data;

@Data
public class ProblemTagRelation {
    Integer id;
    Integer problemId;
    Integer tagId;
}
