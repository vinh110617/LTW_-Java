package com.example.bai2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// Tắt cấu hình tự động tìm Database
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Bai2Application {

    public static void main(String[] args) {
        SpringApplication.run(Bai2Application.class, args);
    }
}