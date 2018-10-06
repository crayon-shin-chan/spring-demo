package czy.demo.beanfactory.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * BeanFactory后处理器,可以作为Bean注入容器
 */
@Component
public class SimpleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("进入BeanFactory后处理方法");
        System.out.println("单例Bean名称为: "+Arrays.toString(beanFactory.getSingletonNames()));
    }
}
