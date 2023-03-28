package top.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.example.web.interceptor.rules.CheckParams;
import top.example.web.interceptor.rules.CheckRule;
import top.example.web.interceptor.rules.CheckType;

@Controller
public class TestParamCheckController {

    @GetMapping("/check")
    @ResponseBody
    @CheckParams(rules = {
            @CheckRule(attrName = "age",
                    type = CheckType.INT_MAX,
                    value = "20"),
            @CheckRule(attrName = "email",
            type = CheckType.EMAIL)})
    public String check(Integer age,String email) {
        return "success";
    }
}
