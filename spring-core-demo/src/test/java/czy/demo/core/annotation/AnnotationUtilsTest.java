package czy.demo.core.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import static org.junit.jupiter.api.Assertions.*;

/* AnnotationUtils注解工具类测试 */
public class AnnotationUtilsTest {

    @Test
    public void find()throws NoSuchMethodException{

        Order classOrder = AnnotationUtils.findAnnotation(AnnotationUtilsMain.class,Order.class);
        assertEquals(1000,classOrder.value(),"类序号不是1000");

        Order methodOrder = AnnotationUtils.findAnnotation(AnnotationUtilsMain.class.getMethod("order"),Order.class);
        assertEquals(100,methodOrder.value(),"方法序号不是100");
    }

}
