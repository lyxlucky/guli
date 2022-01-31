package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liao 2021/10/9
 */
@SpringBootApplication
@MapperScan("com.lyx.dao")
@ComponentScan(basePackages = {"com.lyx"})
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableFeignClients
public class EduMain {
    public static void main(String[] args) {
        SpringApplication.run(EduMain.class,args);
    }
}
