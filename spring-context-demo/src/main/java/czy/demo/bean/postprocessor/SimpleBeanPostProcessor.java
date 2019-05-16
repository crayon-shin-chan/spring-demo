package czy.demo.bean.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后处理器实现
 */
@Component
public class SimpleBeanPostProcessor implements BeanPostProcessor {


    /**
     * 初始化之前处理方法,此时Bean对象已经创建,属性也已经设置,不太明白这个初始化什么意思
     * @param bean
     * @param beanName
     * @return: 返回值为null时,对bean没有影响,如果重新设置了bean的属性,则修改会保留
     *          返回值为相应类型Bean时,会覆盖原有Bean
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("实例化之前处理");
        System.out.println("bean name is :"+beanName);
        System.out.println(bean);
        System.out.println();
        if(bean instanceof  Person){
            ((Person) bean).setName("hehe");
            //return new Person("hehe",12);
        }
        return null;
    }

    /**
     * 没有搞清楚这个初始化之前之后有什么区别
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("实例化之后处理");
        System.out.println("bean name is :"+beanName);
        System.out.println(bean);
        System.out.println();
        return null;
    }
}
