package czy.demo.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class SimpleInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("进入实例化之前处理方法");
        System.out.println("bean class is : "+beanClass.getName());
        System.out.println("bean name is : "+beanName);
        System.out.println();
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("进入实例化之后处理方法");
        System.out.println("bean name is : "+beanName);
        System.out.println();
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("进入设置属性之后处理方法");
        System.out.println("bean name is : "+beanName);
        System.out.println("bean properties is :");
        Iterator<PropertyValue> iterator = pvs.iterator();
        while(iterator.hasNext()){
            PropertyValue value = iterator.next();
            System.out.println("name: "+value.getName()+",value: "+value.getValue());
        }
        System.out.println();
        return null;
    }
}
