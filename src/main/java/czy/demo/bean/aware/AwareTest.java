package czy.demo.bean.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AwareTest.class)
public class AwareTest {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AwareTest.class);
    }

}
