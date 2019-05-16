package czy.demo.resource;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;


public class ClassPathResourceTest {

    public static void main(String[] args)throws Exception{

        /* 可以直接加载打包进类路径的资源文件 */
        ClassPathResource resource = new ClassPathResource("czy/demo/resource/beans.xml");
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
