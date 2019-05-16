package czy.demo.proxy.factory.before;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.AopProxyFactory;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import static org.junit.jupiter.api.Assertions.*;

/* 基于AopProxyFactory的前置通知测试 */
public class SingerBeforeAdviceTest {

    private static AopProxyFactory factory;



    @BeforeAll
    public static void beforeAll(){
        factory = new DefaultAopProxyFactory();
    }

    @Test
    public void sing(){
        AdvisedSupport advisedSupport =new AdvisedSupport();
        advisedSupport.setTarget(new Singer());
        advisedSupport.addAdvice(new SingerBeforeAdvice("sing"));
        AopProxy aopProxy = factory.createAopProxy(advisedSupport);
        Singer singer = (Singer)aopProxy.getProxy();
        singer.noise();
        assertThrows(RuntimeException.class,()->{singer.sing();});
    }

    @Test
    public void noise(){
        AdvisedSupport advisedSupport =new AdvisedSupport();
        advisedSupport.setTarget(new Singer());
        advisedSupport.addAdvice(new SingerBeforeAdvice("noise"));
        AopProxy aopProxy = factory.createAopProxy(advisedSupport);
        Singer singer = (Singer)aopProxy.getProxy();
        singer.sing();
        assertThrows(RuntimeException.class,()->{singer.noise();});
    }

}
