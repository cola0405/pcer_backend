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
    public R newProblem(@Validated @RequestBody NewProblemReq req) throws Exception {
        problemService.newProblem(req);
        return R.success();
    }

    @GetMapping("/get")
    public ProblemItem getProblem(@RequestParam("id") Integer id){
        ProblemItem item = problemService.getProblemById(id);
        return item;
    }
}
