package com.lagou.controller;

import com.lagou.entity.Resume;
import com.lagou.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Value("${server.port}")
    private Integer port;


    @GetMapping("/openstate/{id}")
    public Resume findDefaultResumeState(@PathVariable Long id) {
        return resumeService.findResumById(id);
    }

    @GetMapping("/ribbon")
    public Integer ribbon() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

    @GetMapping("/fegin")
    public Integer fegin() {
        return port;
    }
}