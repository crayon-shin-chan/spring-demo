package czy.demo.bean.postprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = BeanPostProcessorTest.class)
public class BeanPostProcessorTest {

    @Bean
    public Person zhangsan(){
        return new Person("zhangsan",23);
    }

    @Bean
    public Person lisi(){
        return new Person("lisi",25);
    }

    @Bean
    public Person wangwu(){
        return new Person("wangwu",30);
    }


    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanPostProcessorTest.class);
        Person zhangsan = (Person)context.getBean("zhangsan");
        Person lisi = (Person)context.getBean("lisi");
        Person wangwu = (Person)context.getBean("wangwu");
        System.out.println(zhangsan);
        System.out.println(lisi);
        System.out.println(wangwu);
    }


}
