package czy.demo.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = PrototypeTest.class)
public class PrototypeTest {


    public static void main(String[] args){

        ApplicationContext context = new AnnotationConfigApplicationContext(PrototypeTest.class);

        System.out.println(context.getBean(Person.class));

        System.out.println(context.getBean(Person.class,"张三"));

        System.out.println(context.getBean(Person.class,"翠山","张"));

        System.out.println(context.getBean(Person.class,"爱德华",8));

    }

}
