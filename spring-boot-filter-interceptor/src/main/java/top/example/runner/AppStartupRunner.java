package top.example.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationArguments参数名称:{}",args.getOptionNames());
        log.info("ApplicationArguments参数值:{}",args.getOptionValues("age"));
        log.info("ApplicationArguments参数:{}", Arrays.toString(args.getSourceArgs()));
    }
}
