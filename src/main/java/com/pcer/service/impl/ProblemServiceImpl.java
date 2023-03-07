package com.pcer.service.impl;

import com.pcer.dao.ProblemDao;
import com.pcer.entity.Problem;
import com.pcer.entity.res.ProblemItem;
import com.pcer.service.ProblemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProblemServiceImpl implements ProblemService {

    @Resource
    private ProblemDao problemDao;

    @Override
    public List<ProblemItem> getProblems() {
        ArrayList<ProblemItem> res = new ArrayList<>();
        List<Problem> problems = problemDao.getProblems();
        for(Problem problem : problems){
            ProblemItem p = new ProblemItem();
            p.setId(problem.getId());
            p.setName(problem.getName());
            p.setDifficulty(problem.getDifficulty());
            p.setTags(problemDao.getProblemTags());
            res.add(p);
        }
        return res;
    }
}
