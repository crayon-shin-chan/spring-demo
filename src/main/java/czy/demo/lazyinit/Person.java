package czy.demo.lazyinit;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 懒惰初始化单例模式(singleton),容器启动不会创建,第一次获取创建,后面再次获取返回单例
 */
@Lazy
@Component
public class Person {

    public Person(){
        System.out.println("Person 初始化");
    }

}
