package com.pcer.service.impl;

import com.pcer.dao.ProblemDao;
import com.pcer.dao.TagDao;
import com.pcer.entity.Problem;
import com.pcer.entity.req.NewProblemReq;
import com.pcer.entity.req.UpdateProblemReq;
import com.pcer.entity.res.ProblemItem;
import com.pcer.exception.CodeEnum;
import com.pcer.service.ProblemService;
import com.pcer.util.MapTool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;


@Service
public class ProblemServiceImpl implements ProblemService {

    @Resource
    private ProblemDao problemDao;

    @Resource
    private TagDao tagDao;

    @Resource
    private MapTool mapTool;

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
            p.setTags(problemDao.getProblemTags(problem.getId()));
            res.add(p);
        }
        return res;
    }

    @Override
    public void newProblem(NewProblemReq req) throws Exception {
        Problem p = new Problem();
        p.setName(req.getName());
        p.setDifficulty(req.getDifficulty());
        p.setContent(req.getContent());
        int res = problemDao.newProblem(p);
        CodeEnum.fail.assertIsEquals(res, 1);

        // insert tag
        for(String tag : req.getSelectedTags()){
            Integer problemId = p.getId();
            Integer tagId = mapTool.tag2Id(tag);
            problemDao.addTag(problemId, tagId);
        }
    }

    @Override
    public ProblemItem getProblemById(Integer id) {
        ProblemItem problem = problemDao.getProblemById(id);
        return problem;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateProblem(UpdateProblemReq req) {
        Integer problemId = req.getId();
        problemDao.updateProblem(req);
        ArrayList<String> oldTags = problemDao.getProblemTagNames(problemId);
        ArrayList<String> newTags = req.getSelectedTags();

        // delete tag
        for (String tag : oldTags){
            if (!newTags.contains(tag)){
                Integer tagId = mapTool.tag2Id(tag);
                problemDao.removeTag(problemId, tagId);
            }
        }

        // add tag
        for (String tag : newTags){
            if (!oldTags.contains(tag)){
                Integer tagId = mapTool.tag2Id(tag);
                problemDao.addTag(problemId, tagId);
            }
        }

    }


}
