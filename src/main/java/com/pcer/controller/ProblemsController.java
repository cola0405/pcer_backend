package com.pcer.controller;

import com.pcer.entity.req.NewProblemReq;
import com.pcer.entity.req.UpdateProblemReq;
import com.pcer.entity.res.ProblemItem;
import com.pcer.entity.res.R;
import com.pcer.entity.res.RD;
import com.pcer.service.ProblemService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemsController {

    @Resource
    ProblemService problemService;

    @RequestMapping("/getList")
    public RD getProblems(){
        ArrayList<ProblemItem> problemList = problemService.getProblems();
        return RD.success().putData("problemList", problemList);
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

    @PostMapping("/update")
    public R updateProblem(@RequestBody UpdateProblemReq req){
        problemService.updateProblem(req);
        return R.success();
    }

}
