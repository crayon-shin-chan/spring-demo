package czy.demo.core.io;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;


public class FileSystemResourceTest {

    @Test
    public void simple()throws IOException {
        /* spring的ResourceUtils可以直接获取类路径下文件的绝对路径,需要URL解码 */
        String path = ResourceUtils.getURL("classpath:db.properties").getPath();
        Resource resource = new FileSystemResource(path);
        assertTrue(resource.exists(),"资源不存在");
        assertTrue(resource.isFile(),"资源不是文件");
        assertFalse(resource.isOpen(),"资源已经打开");
        assertTrue(resource.isReadable(),"资源不可读");
        assertTrue(((FileSystemResource) resource).isWritable(),"资源不可写");
        assertEquals("db.properties",resource.getFilename(),"文件名称不正确");
    }

}
