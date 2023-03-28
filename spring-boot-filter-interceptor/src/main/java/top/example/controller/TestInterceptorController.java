package top.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestInterceptorController {

    @GetMapping("/interceptor")
    @ResponseBody
    public String testInterceptor(){
        System.out.println("TestInterceptorController已执行完毕");
        return "success";
    }


}
