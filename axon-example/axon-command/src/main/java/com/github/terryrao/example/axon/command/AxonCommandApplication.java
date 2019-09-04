package com.github.terryrao.example.axon.command;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author raow date: 2019/9/3 18:21
 */

@SpringBootApplication
@Configuration
@MapperScan("com.github.terryrao.example.axon.command.repository.*")
public class AxonCommandApplication {
    public static void main(String[] args) {
        SpringApplication.run(AxonCommandApplication.class,args);
    }
}


