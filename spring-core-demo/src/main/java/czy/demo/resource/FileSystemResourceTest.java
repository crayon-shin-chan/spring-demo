package czy.demo.resource;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.InputStream;
import java.net.URLDecoder;


public class FileSystemResourceTest {

    public static void main(String[] args)throws Exception{

        /* spring的ResourceUtils可以直接获取类路径下文件的绝对路径,需要URL解码 */
        String path = ResourceUtils.getURL("classpath:czy/demo/resource/beans.xml").getPath();
        System.out.println(URLDecoder.decode(path));
        Resource resource = new FileSystemResource(URLDecoder.decode(path));
        System.out.println("资源是否存在: "+resource.exists());
        System.out.println("资源路径为: "+((FileSystemResource) resource).getPath());
        System.out.println("资源内容为: ");
        InputStream in = resource.getInputStream();
        byte[] bytes = new byte[1048];
        int length = 0;
        while((length = in.read(bytes))!=-1){
            System.out.println(new String(bytes,0,length));
        }
    }

}
