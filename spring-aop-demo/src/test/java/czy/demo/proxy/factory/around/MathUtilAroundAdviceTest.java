package czy.demo.proxy.factory.around;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.AopProxyFactory;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import static org.junit.jupiter.api.Assertions.*;

/* 基于AopProxyFactory的环绕通知测试 */
public class MathUtilAroundAdviceTest {

    private static AopProxyFactory factory;

    @BeforeAll
    public static void beforeAll(){
        factory = new DefaultAopProxyFactory();
    }

    @Test
    public void around1(){
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.addAdvice(new MathUtilAroundAdvice(1));
        advisedSupport.setTarget(new MathUtil());
        AopProxy aopProxy = factory.createAopProxy(advisedSupport);
        MathUtil mathUtil = (MathUtil)aopProxy.getProxy();
        int sum = mathUtil.add(1,1);
        assertEquals(sum,3,"相加结果不相同");
    }

    @Test
    public void around2(){
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.addAdvice(new MathUtilAroundAdvice(2));
        advisedSupport.setTarget(new MathUtil());
        AopProxy aopProxy = factory.createAopProxy(advisedSupport);
        MathUtil mathUtil = (MathUtil)aopProxy.getProxy();
        int sum = mathUtil.add(10,10);
        assertEquals(sum,22,"相加结果不相同");
    }

}
