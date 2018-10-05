package czy.demo.prototype;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Bean为原型模式时,可以在获取Bean时指定构造函数参数或者工厂方法参数
 * 容器会自动匹配合适的构造函数
 */
@Scope("prototype")
@Component
public class Person {

    private String name;

    public Person(){
        this(new Date().toString());
    }

    public Person(String name){
        this.name = name;
    }

    public Person(String firstName,String lastName){
        this(firstName+" "+lastName);
    }

    public Person(String name,Integer c){
        this(name+" "+c+"世");
    }


    public String toString(){
        return "Person name is : "+name;
    }


}
