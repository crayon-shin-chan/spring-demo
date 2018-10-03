package czy.demo.beanfactory.simple;


public class Person {

    private String name;

    public Person(String name){
        this.name = name;
    }

    public void say(){
        System.out.println("my name is "+name);
    }

}
