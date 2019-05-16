package czy.demo.proxy.factory.before;

/* 目标类，被拦截 */
public class Singer {

    public void sing(){
        System.out.println("take me to your heart");
    }

    public void noise() {System.out.println("balabalabalabalabala");}

}
