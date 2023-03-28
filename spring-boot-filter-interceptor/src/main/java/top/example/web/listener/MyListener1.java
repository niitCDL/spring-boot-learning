package top.example.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import top.example.web.event.MyEvent;

@Slf4j
public class MyListener1 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s 监听到事件源: %s.",MyListener1.class.getName(),event.getSource()));
    }
}
