package czy.demo.resource;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class ClassPathResourceTest {

    @Test
    public void simple()throws IOException {
        ClassPathResource resource = new ClassPathResource("db.properties");
        assertEquals("db.properties",resource.getPath(),"资源路径不正确");
        assertTrue(resource.exists(),"资源不存在");
    }

}
