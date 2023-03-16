package com.pcer.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pcer.entity.Problem;
import com.pcer.entity.Tag;
import com.pcer.entity.res.ProblemItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;


@Mapper
public interface ProblemDao extends BaseMapper<Problem> {
    ArrayList<Problem> getProblems();
    Integer newProblem(Problem problem);
    ProblemItem getProblemById(Integer id);
    ArrayList<Tag> getProblemTags();
}
