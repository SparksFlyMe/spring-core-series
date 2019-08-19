package com.kaizhang.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author ：kaizhang
 * @date ：2019/8/18 21:49
 */
@Service
public class MyEventListenerByAnnotation {
    @EventListener(classes = {ApplicationEvent.class})
    public void lister(ApplicationEvent event) {
        System.out.println("MyEventListenerByAnnotation...监听到的事件：" + event);
    }
}
