package czy.demo.lazyinit;

import org.springframework.stereotype.Component;

/**
 * 单例模式(singleton),容器启动即创建,每次获取返回单例
 */
@Component
public class Human {

    public Human(){
        System.out.println("Human 初始化");
    }


}
