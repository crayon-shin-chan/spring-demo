package czy.demo.beanfactory.xml;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class XmlBeanFactoryTest {

    public static void main(String[] args){
        Resource resource = new ClassPathResource("czy/demo/beanfactory/xml/beans.xml");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        Person person  = factory.getBean(Person.class);
        System.out.println(person);
    }

}
