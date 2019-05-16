package czy.demo.proxy.factory.around;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/* MethodInterceptor为AOP标准里的方法拦截器，用于生成环绕通知
 * 这个接口为aopalliance标准提供
 */
public class MathUtilAroundAdvice implements MethodInterceptor {

    private int offset;

    public MathUtilAroundAdvice(int offset){
        this.offset = offset;
    }

    /* MethodInvocation包含了方法调用的全部信息，最后返回值作为代理对象方法调用的返回值 */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("当前调用对象类型为："+invocation.getThis().getClass().getName());
        System.out.println("当前调用方法名为："+invocation.getMethod().getName());
        System.out.println("当前调用方法参数为：");
        for(int i=0;i<invocation.getArguments().length;i++){
            System.out.println("参数"+(i+1)+"："+invocation.getArguments()[i]);
        }
        Object value = invocation.proceed();
        System.out.println("当前调用方法直接返回值为："+value);

        /* 修改制定方法返回值 */
        if(invocation.getMethod().getName().equals("add")){
            System.out.println("当前返回值偏移为："+offset);
            return (int)value+offset;
        }
        return value;
    }
}
