package com.pcer;

import com.pcer.controller.ProblemsController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class PcerApplicationTests {

    @Resource
    ProblemsController problemsController;

    @Test
    void contextLoads() {
    }

    @Test
    public void difficulty(){
        System.out.println(problemsController.getProblems());
    }

}
