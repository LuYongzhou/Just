package com.lu.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/5/2
 */
@EnableEurekaServer
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMain.class,args);
    }
}
