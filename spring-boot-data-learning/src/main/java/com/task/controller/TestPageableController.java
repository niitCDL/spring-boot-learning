package com.task.controller;

import com.task.domain.Discuss;
import com.task.repository.DiscussRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestPageableController {

    @Autowired
    DiscussRepository discussRepository;

    @GetMapping("/getPageList")
    public List<Discuss> getPageList(Integer aid,
                                     @RequestParam(defaultValue = "1") Integer pageNo,
                                     @RequestParam(defaultValue = "2")Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        List<Discuss> list = discussRepository.getDiscussesByPage(aid,pageable);
        return list;
    }
}
