package czy.demo.core.annotation;

import org.springframework.core.annotation.Order;

@Order(1000)
public class AnnotationUtilsMain {

    @Order(100)
    public static void order(){

    }

}
