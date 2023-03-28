package top.example.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 实现CommandLineRunner、ApplicationRunner接口,通常应用于应用启动前的特殊代码执行,比如:
 *  将系统常用的数据加载到内存
 *  应用上一次运行的垃圾数据清理
 *  系统启动成功后的通知的发送
 */
@Component
@Slf4j
public class CommandLineStartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineStartupRunner 传入参数:{}", Arrays.toString(args));
    }
}
