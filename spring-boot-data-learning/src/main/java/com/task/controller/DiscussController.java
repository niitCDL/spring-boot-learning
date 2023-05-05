package com.task.controller;

import com.task.repository.DiscussRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DiscussController {

    @Autowired
    private DiscussRepository discussRepository;


//    @GetMapping("/")
//    public String getDiscuss(Model model){
//        PageRequest of = PageRequest.of(0, 3);
//        List<Discuss> discussesByPage = discussRepository.getDiscussesByPage(1, of);
//        model.addAttribute("title","hello world");
//        model.addAttribute("list",discussesByPage);
//        return "index.html";
//    }

}
