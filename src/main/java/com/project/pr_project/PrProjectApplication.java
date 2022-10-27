package com.project.pr_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class PrProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrProjectApplication.class, args);
    }

}
