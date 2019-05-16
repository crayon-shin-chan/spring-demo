package czy.demo.resource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class ClassPathResourceTest {

    @Test
    @DisplayName("ClassPathResource简单测试")
    public void simple()throws IOException {
        /* 直接加载类路径的资源文件，资源文件不需要在test目录下 */
        ClassPathResource resource = new ClassPathResource("db.properties");
        System.out.println("资源路径为: "+resource.getPath());
        System.out.println("资源是否存在: "+resource.exists());
        System.out.println("资源内容为: ");
        InputStream in = resource.getInputStream();
        byte[] bytes = new byte[1048];
        int length = 0;
        while((length = in.read(bytes))!=-1){
            System.out.println(new String(bytes,0,length));
        }
    }


}
