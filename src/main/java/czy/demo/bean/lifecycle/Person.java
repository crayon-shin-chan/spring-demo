package czy.demo.bean.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Person implements InitializingBean,DisposableBean {

    @Autowired
    @Qualifier("hehe")
    private String name;

    public Person(){
        System.out.println("执行构造函数");
        System.out.println();
    }


    @PostConstruct
    public void initMethod(){
        System.out.println("执行定制初始化方法");
        System.out.println("person name is : "+getName());
        System.out.println();
    }

    @PreDestroy
    public void destoryMethod(){
        System.out.println("执行定制销毁方法");
        System.out.println("person name is : "+getName());
        System.out.println();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行继承初始化方法");
        System.out.println("person name is : "+getName());
        System.out.println();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行继承销毁方法");
        System.out.println("person name is : "+getName());
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
