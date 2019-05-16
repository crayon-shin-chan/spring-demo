package czy.demo.bean.lazyinit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = LazyInitTest.class)
public class LazyInitTest {

    public static void main(String[] args){

        System.out.println("创建上下文");
        ApplicationContext context = new AnnotationConfigApplicationContext(LazyInitTest.class);

        System.out.println("获取单例模式Bean");
        Human human = (Human)context.getBean(Human.class);

        System.out.println("获取懒惰初始化Bean");
        Person person = (Person)context.getBean(Person.class);

        System.out.println("获取原型模式Bean");
        People people = (People)context.getBean(People.class);

        System.out.println("获取单例模式Bean");
        Human human1 = (Human)context.getBean(Human.class);

        System.out.println("获取懒惰初始化Bean");
        Person person1 = (Person)context.getBean(Person.class);

        System.out.println("获取原型模式Bean");
        People people1 = (People)context.getBean(People.class);
    }

}
