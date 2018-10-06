package czy.demo.bean.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * Aware接口用于向Bean注入各种对象
 */
@Component
public class Person implements ApplicationContextAware,ApplicationEventPublisherAware,BeanNameAware,BeanFactoryAware,ResourceLoaderAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用setBeanFactory方法");
        System.out.println(beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("调用setBeanName方法");
        System.out.println("bean name is : "+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("调用setApplicationContext方法");
        System.out.println(applicationContext.getId()+applicationContext.getApplicationName()+applicationContext.getDisplayName());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("调用setApplicationEventPublisher方法");
        System.out.println(applicationEventPublisher.toString());
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("调用setResourceLoader方法");
        System.out.println(resourceLoader.toString());
    }
}
