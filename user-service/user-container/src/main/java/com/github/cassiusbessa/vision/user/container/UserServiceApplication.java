package com.github.cassiusbessa.vision.user.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.github.cassiusbessa.vision.application.service",
        "com.github.cassiusbessa.vision",
})
@EnableJpaRepositories(basePackages = "com.github.cassiusbessa.vision.common.dataaccess")
@EntityScan(basePackages = "com.github.cassiusbessa.vision")
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}