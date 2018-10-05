package czy.demo.bean.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = BeanLifeCycleTest.class)
public class BeanLifeCycleTest {

    @Bean
    public String hehe(){
        return new String("张三");
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanLifeCycleTest.class);
        System.out.println("停止上下文");
        context.stop();
        System.out.println("启动上下文");
        context.start();
        System.out.println("销毁上下文");
        context.destroy();
    }


}
