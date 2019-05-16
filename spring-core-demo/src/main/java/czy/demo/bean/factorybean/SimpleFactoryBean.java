package czy.demo.bean.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 工厂Bean,需要实现FactoryBean接口
 */
@Component("person")
public class SimpleFactoryBean implements FactoryBean {

    /* 是否是单例模式 */
    @Override
    public boolean isSingleton() {
        return true;
    }

    /* 返回Bean对象 */
    @Override
    public Object getObject() throws Exception {
        return new Person();
    }

    /* Bean类型 */
    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public String toString() {
        return "SimpleFactoryBean{}";
    }
}
