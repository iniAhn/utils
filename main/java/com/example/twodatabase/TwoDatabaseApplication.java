package com.example.twodatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TwoDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwoDatabaseApplication.class, args);
    }

}
