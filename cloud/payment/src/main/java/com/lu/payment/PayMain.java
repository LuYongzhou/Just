package com.lu.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/4/23
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.lu.payment.mapper")
public class PayMain {
    public static void main(String[] args) {
        SpringApplication.run(PayMain.class,args);
    }
}
