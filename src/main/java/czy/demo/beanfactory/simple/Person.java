package czy.demo.beanfactory.simple;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/* 当使用Scope注解时,会创建一个默认实例,然后当传递参数创建Bean时,会调用相应构造函数 */
@Scope("prototype")
/* Component创建Bean时,value为组件名称 */
@Component("hehehehehe")
public class Person {

    private String name;

    public Person(){
        this("默认用户");
    }


    public Person(String name){
        this.name = name;
    }

    public void say(){
        System.out.println("my name is "+name);
    }

}
