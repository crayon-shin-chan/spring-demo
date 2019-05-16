package czy.demo.proxy.factory.before;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/* 前置通知为MethodBeforeAdvice，继承了Advice接口，此接口为spring提供，而不是aopalliance */
public class SingerBeforeAdvice implements MethodBeforeAdvice {

    /* 阻止调用的方法名 */
    private String preventMethod;

    public SingerBeforeAdvice(String preventMethod){
        this.preventMethod = preventMethod;
    }


    /* 前置通知无法手动控制方法调用，只能通过抛出异常阻止方法调用 */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        System.out.println("当前调用对象所属类型为："+target.getClass().getName());
        System.out.println("当前调用方法为："+method.getName());
        System.out.println("当前调用方法参数为：");
        for(int i=0;i<args.length;i++){
            System.out.println("参数"+(i+1)+"："+args[i]);
        }

        if(method.getName().equals(preventMethod)){
            System.out.println("不能调用方法："+method.getName());
            throw new RuntimeException("不能调用方法："+preventMethod);
        }else{
            System.out.println("可以调用方法："+method.getName());
        }

    }

}
