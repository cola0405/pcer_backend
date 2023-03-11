package com.pcer.service;


import com.pcer.entity.Problem;
import com.pcer.entity.req.NewProblemReq;
import com.pcer.entity.res.ProblemItem;

import java.util.List;

public interface ProblemService {
    List<ProblemItem> getProblems();
    void newProblem(NewProblemReq req) throws Exception;
    ProblemItem getProblemById(Integer id);
}
