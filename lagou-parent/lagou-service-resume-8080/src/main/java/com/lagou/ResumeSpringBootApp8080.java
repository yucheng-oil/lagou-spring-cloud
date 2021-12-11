package com.lagou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.lagou.mapper")
//@EnableEurekaClient //开启Eureka Client （Eureka独有）
@EnableDiscoveryClient // 开启注册中心客户端（通用型注解，比如zookeeper，nacos）
            //springcloud的Edgware版本开始，不加注解也OK
public class ResumeSpringBootApp8080 {

    public static void main(String[] args) {
        SpringApplication.run(ResumeSpringBootApp8080.class, args);
    }

}
