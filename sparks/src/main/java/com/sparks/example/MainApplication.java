package com.sparks.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * SpringBootApplication annotation tells Spring to help out wherever possible
 * it pulls in component scanning, autoconfiguration, and property support
 * this effectively fires up the servlet container and serves the service 
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String... args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
