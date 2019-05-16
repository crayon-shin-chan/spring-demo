package czy.demo.proxy.factory.around;

/* 目标类，被拦截 */
public class MathUtil {

    public int add(int a,int b){
        return a+b;
    }
}
