package czy.demo.applicationcontext.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义上下文事件监听器
 * 默认情况下只有一个上下文刷新事件
 */
@Component
public class SimpleEventListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("监听到ApplicationEvent");
        System.out.println(event.getSource());
        System.out.println(event.getTimestamp());
        System.out.println(event.toString());
        System.out.println();
    }
}
