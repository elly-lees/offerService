package com.worldpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


/**
 * The class Application
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan({ "com.worldpay.***" })
public class Application {
    /**
     * The main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
