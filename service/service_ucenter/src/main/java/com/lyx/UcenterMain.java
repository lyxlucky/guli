package com.lyx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liao 2021/10/20
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyx.dao")
public class UcenterMain {
    public static void main(String[] args) {
        SpringApplication.run(UcenterMain.class,args);
    }
}
