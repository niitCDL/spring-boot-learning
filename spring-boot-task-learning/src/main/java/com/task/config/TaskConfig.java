package com.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 任务线程池配置
 */
@Configuration
public class TaskConfig {

    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(12);//初始化的时候给的线程数
        executor.setMaxPoolSize(26);
        executor.setQueueCapacity(200);
        executor.setKeepAliveSeconds(120);
        //当关闭的时候会去把任务执行完(可能不会执行完所有的任务 因为有的任务的执行时间可能会很长)
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //当等待了那么久的时候任务还没有执行完,则会直接关闭线程池
        executor.setAwaitTerminationSeconds(180);
        executor.setThreadNamePrefix("cdlTask-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
