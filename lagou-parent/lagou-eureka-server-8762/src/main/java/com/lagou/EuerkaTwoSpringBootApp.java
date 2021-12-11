package com.lagou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//声明当前项目为Eureka服务
@EnableEurekaServer
public class EuerkaTwoSpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(EuerkaTwoSpringBootApp.class, args);
    }

}
