package com.pcer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@Data
@TableName("problem")
public class Problem implements Serializable {
    @TableId(type = IdType.AUTO)
    Integer id;

    String name;
    String difficulty;
    String content;

    ArrayList<String> d = new ArrayList<>(Arrays.asList("简单","中等","困难"));
    public void setDifficulty(String difficulty){
        this.difficulty =  d.get(Integer.parseInt(difficulty));
    }

    public void setDifficultyValue(String difficulty){
        this.difficulty =  String.valueOf(d.indexOf(difficulty));
    }
}
