package czy.demo.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化前处理");
        System.out.println("bean name is : "+beanName);
        if(bean instanceof  Person){
            System.out.println("person name is : "+((Person) bean).getName());
        }
        System.out.println();
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化后处理");
        System.out.println("bean name is : "+beanName);
        if(bean instanceof  Person){
            System.out.println("person name is : "+((Person) bean).getName());
        }
        System.out.println();
        return bean;
    }
}
