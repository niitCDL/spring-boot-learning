package com.example.controller;

import com.example.domain.Discuss;
import com.example.repository.DiscussRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
