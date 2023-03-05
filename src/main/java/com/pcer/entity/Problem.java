package com.pcer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("problem")
public class Problem implements Serializable {

    @TableId(type = IdType.AUTO)
    Integer id;

    String name;
    String difficulty;
}
