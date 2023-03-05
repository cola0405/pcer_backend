package com.pcer.controller;

import com.pcer.entity.Problem;
import com.pcer.service.ProblemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemsController {

    @Resource
    ProblemService problemService;

    @RequestMapping("/get")
    public List<Problem> hello(){
        return problemService.getProblems();
    }
}
