package czy.demo.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 当同一类型Bean有多个时,在通过类型Autowired与直接获取Bean时
 * 如果都没有Primary注解,则抛出异常,无法决定应该获取哪个Bean
 * 如果只有一个Primary注解,则选择这个Bean
 * 如果有多个Primary注解,则还是无法决定
 */
@Configuration
public class PrimaryTest {


    @Bean
    //@Primary
    public Person zhangsan(){
        return new Person("zhangsan");
    }

    @Bean
    @Primary
    public Person lisi(){
        return new Person("lisi");
    }

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(PrimaryTest.class);
        Person person = (Person)context.getBean(Person.class);
        System.out.println(person);
    }

}
