package com.github.terryrao.example.axon.query;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * @author raow
 */
@EnableLoadTimeWeaving
@EnableSpringConfigured
@SpringBootApplication
public class AxonQueryApplication {
    public static void main(String[] args) {

    }
}
