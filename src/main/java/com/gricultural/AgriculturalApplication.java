package com.gricultural;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@ComponentScan(basePackages = {"com.gricultural.mapper"})
@MapperScan("com.gricultural.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class AgriculturalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgriculturalApplication.class, args);
    }

}
