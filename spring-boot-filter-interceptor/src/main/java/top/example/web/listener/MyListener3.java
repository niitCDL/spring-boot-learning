package top.example.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import top.example.web.event.MyEvent;

@Slf4j
public class MyListener3 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s 监听到事件源: %s.", MyListener3.class.getName(),event.getSource()));
    }
}
