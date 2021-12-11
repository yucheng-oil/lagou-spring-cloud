package com.lagou.controller;


import com.lagou.service.ResumeServiceFeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("")
public class AutoController {

    @Autowired
    private ResumeServiceFeginClient resumeServiceFeginClient;

    @GetMapping("/autodeliver/fegin")
    public Integer fegin() {
        return resumeServiceFeginClient.findPort();
    }

    @GetMapping("/demo/fegin")
    public Integer demo() {
        return resumeServiceFeginClient.findPort();
    }

    @GetMapping("/others/fegin")
    public Integer others() {
        return resumeServiceFeginClient.findPort();
    }
    /*
        定义回退方法，返回预设的默认值
    */
    public Integer fallback() {
        return -1;
    }
}