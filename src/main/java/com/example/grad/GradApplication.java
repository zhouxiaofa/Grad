package com.example.grad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zxf
 */
@MapperScan("com.example.grad.mapper")
@SpringBootApplication
public class GradApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradApplication.class, args);
    }

}
