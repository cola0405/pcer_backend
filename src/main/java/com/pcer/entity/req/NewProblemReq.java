package com.pcer.entity.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NewProblemReq {
    @NotNull(message = "题目名不能为空")
    String name;
    @NotNull(message = "题目难度不能为空")
    String difficulty;
    @NotNull(message = "题目内容不能为空")
    String content;
}
