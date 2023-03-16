package com.pcer.service.impl;

import com.pcer.dao.ProblemDao;
import com.pcer.entity.Problem;
import com.pcer.entity.req.NewProblemReq;
import com.pcer.entity.res.ProblemItem;
import com.pcer.exception.CodeEnum;
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
    public ArrayList<ProblemItem> getProblems() {
        ArrayList<ProblemItem> res = new ArrayList<>();
        ArrayList<Problem> problems = problemDao.getProblems();
        for(Problem problem : problems){
            ProblemItem p = new ProblemItem();
            p.setId(problem.getId());
            p.setName(problem.getName());
            p.setContent(problem.getContent());
            p.setDifficulty(problem.getDifficulty());
            p.setTags(problemDao.getProblemTags());
            res.add(p);
        }
        return res;
    }

    @Override
    public void newProblem(NewProblemReq req) throws Exception {
        Problem p = new Problem();
        p.setName(req.getName());
        p.setContent(req.getContent());
        p.setDifficultyValue(req.getDifficulty());
        System.out.println(req.getContent());
        int res = problemDao.newProblem(p);
        CodeEnum.fail.assertIsEquals(res, 1);
    }

    @Override
    public ProblemItem getProblemById(Integer id) {
        ProblemItem problem = problemDao.getProblemById(id);
        return problem;
    }
}
