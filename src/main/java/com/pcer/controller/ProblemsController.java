package com.pcer.controller;

import com.pcer.entity.req.NewProblemReq;
import com.pcer.entity.res.ProblemItem;
import com.pcer.entity.res.R;
import com.pcer.service.ProblemService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemsController {

    @Resource
    ProblemService problemService;

    @RequestMapping("/getList")
    public List<ProblemItem> getProblems(){
        return problemService.getProblems();
    }

    @PostMapping("/new")
    public R newProblem(@Validated @RequestBody NewProblemReq req){
        System.out.println(req.getContent());
        System.out.println(req.getName());
        return R.success();
    }
}
