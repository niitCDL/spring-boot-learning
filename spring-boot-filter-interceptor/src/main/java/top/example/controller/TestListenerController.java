package top.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping("/api")
public class TestListenerController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/testListener")
    public String testListener(){
//        HttpServletRequest request1 = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        request.setAttribute("author","zs");
        request.setAttribute("author","ls");
        request.removeAttribute("author");
        return "hello listener";
    }
}
