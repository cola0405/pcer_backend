package com.pcer.service.impl;

import com.pcer.dao.ProblemDao;
import com.pcer.entity.Problem;
import com.pcer.service.ProblemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ProblemServiceImpl implements ProblemService {

    @Resource
    private ProblemDao problemDao;

    @Override
    public List<Problem> getProblems() {
        List<Problem> problems = problemDao.getProblems();
        return problems;
    }
}
