package czy.demo.applicationcontext.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = EventTest.class)
public class EventTest {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventTest.class);
        context.publishEvent(new SimpleEvent("hehe"));
        System.out.println("上下文停止");
        context.stop();
        System.out.println("上下文启动");
        context.start();
        System.out.println("上下文关闭");
        context.close();
    }

}
