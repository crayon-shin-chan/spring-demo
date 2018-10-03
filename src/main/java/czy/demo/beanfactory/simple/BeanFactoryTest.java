package czy.demo.beanfactory.simple;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

import java.util.Arrays;
import java.util.Iterator;


/**
 * 最简单的BeanFactory示例
 */
@Configuration
public class BeanFactoryTest {

    /* 配置Bean,名称为方法名 */
    @Bean
    public Person person(){
        return new Person("张三");
    }

    /* 配置Bean,名称为方法名 */
    @Bean
    public Person person1(){
        return new Person("李四");
    }

    /* 这个Bean的参数name为容器注入 */
    @Bean
    public Person custom(String name){
        return new Person(name);
    }

    @Bean
    public String name(){
        return new String("hehe");
    }



    public static void main(String[] args){

        /* 创建容器对象,使用配置类 */
        BeanFactory factory = new AnnotationConfigApplicationContext(BeanFactoryTest.class);

        /* 名称与Bean的映射 */
        say("容器是否包含指定名称Bean");
        say("容器是否包含名为person的bean: "+factory.containsBean("person"));
        say("容器是否包含名为person1的bean: "+factory.containsBean("person1"));
        say("容器是否包含名为person2的bean: "+factory.containsBean("person2"));
        say("");

        /* BeanFactory具有获取别名的接口,但是没有注册别名的接口 */
        say("获取Bean的别名");
        say("person的别名为: "+ Arrays.toString(factory.getAliases("person")));
        say("");

        /* 直接通过name获取Bean,获取失败抛出异常 */
        say("通过名称获取Bean");
        ((Person)factory.getBean("person")).say();
        ((Person)factory.getBean("person1")).say();
        say("");

        /* 同一类型的Bean有多个时不能直接通过类型获取 */
        //factory.getBean(Person.class).say();

        /*获取指定名称Bean,并且使用构造函数参数覆盖默认参数,这里没有成功,使用@Bean注解的方法好像不能这样注入,应该可以在Component形式使用*/
        say("通过名称获取Bean,并且注入构造参数");
        ((Person)factory.getBean("custom","定制用户")).say();
        say("");

        say("获取Bean的对象供应商");
        ObjectProvider<Person> provider = factory.getBeanProvider(Person.class);
        say("");

        say("遍历此类型Bean");
        Iterator<Person> iterator = provider.iterator();
        while(iterator.hasNext()){
            iterator.next().say();
        }
        say("");

        /* 同一类型的Bean包含多个时,查询时需要指定名称,获取失败会抛出异常 */
        say("获取指定名称,指定类型Bean");
        factory.getBean("person",Person.class).say();
        factory.getBean("person1",Person.class).say();
        say("");
    }

    public static void say(Object o){
        System.out.println(o);
    }



}
