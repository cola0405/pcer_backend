package com.pcer.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pcer.entity.Problem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProblemDao extends BaseMapper<Problem> {
    List<Problem> getProblems();
}
