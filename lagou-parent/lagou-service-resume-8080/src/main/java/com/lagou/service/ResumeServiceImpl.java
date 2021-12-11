package com.lagou.service;

import com.lagou.mapper.ResumeMapper;
import com.lagou.entity.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public Resume findResumById(Long id) {
        return resumeMapper.selectById(id);
    }
}
