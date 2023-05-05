package com.task.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class ScheduledJobs {

    //表示方法执行完五秒后继续执行
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayJob() throws InterruptedException {
//        log.info("fixedDelay开始时间: {}",LocalDateTime.now());
//        TimeUnit.SECONDS.sleep(10);
//        log.info("fixedDelay结束时间: {}",LocalDateTime.now());
//    }

//    @Scheduled(fixedRate = 3000)
//    public void fixedRateJob() throws InterruptedException {
//        log.info("fixedRate开始时间: {}",LocalDateTime.now());
//        TimeUnit.SECONDS.sleep(1);
//        log.info("fixedRate结束时间: {}",LocalDateTime.now());
//    }

//    @Scheduled(cron = "0/10 * * * * ?")
//    public void cronJob() throws InterruptedException {
//        log.info("cronJob开始时间: {}",LocalDateTime.now());
//    }

    @Scheduled(cron = "50 23 15 4 4 2")
    public void birthJob() throws InterruptedException {
        log.info("birthJob开始时间: {}",LocalDateTime.now());
    }
}
