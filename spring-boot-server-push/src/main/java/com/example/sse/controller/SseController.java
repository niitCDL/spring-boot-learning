package com.example.sse.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
@Slf4j
public class SseController {

    @RequestMapping(value = "/sse/msg",
            method = RequestMethod.GET,
            produces = "text/event-stream;charset=utf-8")
    public ResponseBodyEmitter pushMsg() throws InterruptedException {
        SseEmitter emitter = new SseEmitter();
//        TimeUnit.SECONDS.sleep(2);
        log.info("emitter push msg...");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = format.format(new Date());
        String msg = "当前时间为: " + dateTime + " 股票的价格为" + new Random().nextInt(101) + "元";
        try {
            emitter.send(msg, MediaType.TEXT_EVENT_STREAM);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return emitter;
    }

}
