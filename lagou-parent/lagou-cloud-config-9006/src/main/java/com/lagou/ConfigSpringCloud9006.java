package com.lagou;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableConfigServer //开启配置中心
public class ConfigSpringCloud9006 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigSpringCloud9006.class,args);
    }
}
