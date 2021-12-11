package com.lagou.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/autodeliver")
public class AutoController {

    @Autowired
    private RestTemplate restTemplate;
//    @GetMapping("/check/{id}")
//    public Resume findDefaultResumeState(@PathVariable Long id) {
//       return restTemplate.getForObject("http://localhost:8080/resume/openstate/" +id , Resume.class);
//    }


    @Autowired
    private DiscoveryClient discoveryClient;
//    /**
//     * 服务注册到Eurake之后的改造
//     *
//     * @param id
//     * @return
//     */
//    @GetMapping("/check/{id}")
//    public Resume findDefaultResumeState(@PathVariable Long id) {
//        // TODO 从Eureka Server中获取我们关注的那个服务的实例信息以及接口信息
//        // 1、从 Eureka Server中获取lagou-service-resume服务的实例信息（使用客户端对象做这件事）
//        List<ServiceInstance> instances
//                = discoveryClient.getInstances("lagou-service-resume");
//        // 2、如果有多个实例，选择一个使用(负载均衡的过程)
//        ServiceInstance serviceInstance = instances.get(0);
//        // 3、从元数据信息获取host port
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        String url = "http://" + host + ":" + port + "/resume/openstate/" + id;
//        System.out.println("===============>>>从EurekaServer集群获取服务实例拼接的url：" + url);
//        // 调用远程服务—> 简历微服务接口  RestTemplate  -> JdbcTempate
//        // httpclient封装好多内容进行远程调用
//        return restTemplate.getForObject(url, Resume.class);
//    }


    /**
     * 试用Ribbon负载均衡
     * <p>
     * 试用@HystrixCommand熔断的一些细节属性配置
     */
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout",
//                    value = "2000")
//    })
//    @GetMapping("/ribbon")
//    public Integer ribbon() {
//        String url = "http://lagou-service-resume/resume/ribbon";
//        return restTemplate.getForObject(url, Integer.class);
//    }

    /**
     * 1）服务提供者处理超时，熔断，返回错误信息，
     * 2）有可能服务提供者出现异常直接抛出异常信息
     */

    @HystrixCommand(
            // 线程池标识，要保持唯一，不唯一的话就共用了
            threadPoolKey = "findResumeOpenStateTimeoutFallback",
            // 线程池细节属性配置
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize",value = "2"), // 线程数
                    @HystrixProperty(name="maxQueueSize",value="20") // 等待队列长度
            },
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "2000"),
            // hystrix高级配置，定制工作过程细节
            // 统计时间窗口定义
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "8000"),
            // 统计时间窗口内的最小请求数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),
            // 统计时间窗口内的错误数量百分比阈值
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
            // 自我修复时的活动窗口长度
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")

            },
            fallbackMethod = "fallback"   //回退方法
    )
    @GetMapping("/ribbon")
    public Integer ribbon() {
        String url = "http://lagou-service-resume/resume/ribbon";
        return restTemplate.getForObject(url, Integer.class);
    }

    /*
        定义回退方法，返回预设的默认值
    */
    public Integer fallback() {
        return -1;
    }
}