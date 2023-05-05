package com.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 任务抽象类
 */
@Slf4j
public abstract class AbstractTask {

    public void doTaskOne() throws InterruptedException {
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        //执行耗时
        TimeUnit.SECONDS.sleep(10);
        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("完成任务一,耗时{}毫秒",resultTime);
    }

    public void doTaskTwo() throws InterruptedException {
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        //执行耗时
        TimeUnit.SECONDS.sleep(5);
        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("完成任务二,耗时{}毫秒",resultTime);
    }

    public void doTaskThree() throws InterruptedException {
        log.info("开始做任务三");
        long start = System.currentTimeMillis();
        //执行耗时
        TimeUnit.SECONDS.sleep(3);
        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("完成任务三,耗时{}毫秒",resultTime);
    }

}
