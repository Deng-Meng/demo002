package com.dm.demo002;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dm.demo002.service")
public class Demo002Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo002Application.class, args);
    }
}
