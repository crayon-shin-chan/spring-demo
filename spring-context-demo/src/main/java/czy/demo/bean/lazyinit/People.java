package czy.demo.bean.lazyinit;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 原型模式(prototype)Bean,容器启动时不会初始化,而是每次获取创建一个
 */
@Scope("prototype")
@Component
public class People {

    public People(){
        System.out.println("People 初始化");
    }


}
