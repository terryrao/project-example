package com.github.terryrao.example.axon.command;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * @author raow date: 2019/9/3 18:21
 */

@EnableLoadTimeWeaving
@EnableSpringConfigured
@SpringBootApplication
public class AxonCommandApplication {
    public static void main(String[] args) {

    }
}


