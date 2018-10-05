package czy.demo.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = FactoryBeanTest.class)
public class FactoryBeanTest {


    public static void main(String[] args){

        ApplicationContext context = new AnnotationConfigApplicationContext(FactoryBeanTest.class);

        /* 直接获取,获取的是FactoryBean的getObject方法返回值 */
        System.out.println("bean is : "+context.getBean("person"));

        /* 加上&前缀,可以获取FactoryBean本身 */
        System.out.println("factory is : "+context.getBean("&person"));
    }

}
