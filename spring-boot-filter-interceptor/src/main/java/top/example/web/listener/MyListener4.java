package top.example.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import top.example.web.event.MyEvent;

@Slf4j
@Component
public class MyListener4{

    @EventListener
    public void listener(MyEvent event) {
        log.info(String.format("%s 监听到事件源: %s.", MyListener4.class.getName(),event.getSource()));
    }
}
