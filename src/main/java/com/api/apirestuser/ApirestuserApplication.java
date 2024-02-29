package com.api.apirestuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {"com.api.apirestuser"})
public class ApirestuserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApirestuserApplication.class, args);
    }

}
