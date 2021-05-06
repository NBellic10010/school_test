package com.golaxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.golaxy.repository")
@EnableScheduling
public class school_test{
    public static void main(String[] args) {
        SpringApplication.run(school_test.class, args);
    }
}

