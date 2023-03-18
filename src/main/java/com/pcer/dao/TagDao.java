package com.pcer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pcer.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.pcer.entity.Tag;

@Mapper
public interface TagDao extends BaseMapper<Tag> {

    ArrayList<Tag> getTagList();
    boolean delete(Integer id);
}
