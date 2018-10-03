package czy.demo.beanfactory.jndi;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.jndi.support.SimpleJndiBeanFactory;

/* Jndi实现的容器需要在JavaEE容器中测试 */
public class JndiBeanFactoryTest {

    public static void main(String[] args){
        /* 呵呵,不好测 */
        BeanFactory factory = new SimpleJndiBeanFactory();
    }


}
