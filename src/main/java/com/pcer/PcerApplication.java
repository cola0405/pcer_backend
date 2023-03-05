package com.pcer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class PcerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PcerApplication.class, args);
    }

}
