package czy.demo.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    /* addStringArray方法为指定数组末尾添加一个元素，返回新数组 */
    @Test
    public void addStringToArray(){
        String[] origin = new String[]{"1","2","3","4","5"};
        String[] target = StringUtils.addStringToArray(origin,"6");

        assertEquals(6,target.length);
        assertEquals("6",target[5]);
        assertNotSame(origin,target);
    }

    /* applyRelativePath会使用Path与相对路径生成一个结果路径
     * 但是，它不会直接拼接，它会把path的最后一个/与relativePath的第一个/合并
     */
    @Test
    public void applyRelativePath1(){
        String path = "/usr/local";
        String relativePath = "/dev";
        String resultPath = StringUtils.applyRelativePath(path,relativePath);
        assertEquals("/usr/dev",resultPath);
    }

    /* 当path以/结束时，会进行拼接，而不是替换 */
    @Test
    public void applyRelativePath2(){
        String path = "/usr/local/";
        String relativePath = "/dev";
        String resultPath = StringUtils.applyRelativePath(path,relativePath);
        assertEquals("/usr/local/dev",resultPath);
    }

    /* 此时也会进行拼接 */
    @Test
    public void applyRelativePath3(){
        String path = "/usr/local/";
        String relativePath = "dev";
        String resultPath = StringUtils.applyRelativePath(path,relativePath);
        assertEquals("/usr/local/dev",resultPath);
    }

    /* 将对象数组转换为逗号分割的字符串 */
    @Test
    public void arrayToCommaDelimitedString(){
        String[] arr = new String[]{"a","b","c","d","e","f"};
        String result = StringUtils.arrayToCommaDelimitedString(arr);
        assertEquals("a,b,c,d,e,f",result);
    }

    /* 将对象数组使用指定分隔符拼接 */
    @Test
    public void arrayToDelimitedString(){
        String[] arr = new String[]{"a","b","c","d","e","f"};
        String result1 = StringUtils.arrayToDelimitedString(arr,"");
        assertEquals("abcdef",result1);
        String result2 = StringUtils.arrayToDelimitedString(arr,"|");
        assertEquals("a|b|c|d|e|f",result2);
    }

    /* 第一个字母改为大写 */
    @Test
    public void capitalize(){
        String origin = "tom";
        String target = StringUtils.capitalize(origin);
        assertEquals("Tom",target);
    }

    /* 替换windows路径分隔符\\为/ */
    @Test
    public void cleanPath(){
        String result = StringUtils.cleanPath("D:\\usr\\local\\aaa");
        assertEquals("D:/usr/local/aaa",result);
    }

    /* 将集合使用逗号拼接 */
    @Test
    public void collectionToCommaDelimitedString(){
        String result = StringUtils.collectionToCommaDelimitedString(Arrays.asList("a","b","c"));
        assertEquals("a,b,c",result);
    }

    /* 集合使用指定字符串拼接 */
    @Test
    public void collectionToDelimitedString1(){
        String result1 = StringUtils.collectionToDelimitedString(Arrays.asList("a","b","c"),"");
        assertEquals("abc",result1);
        String result2 = StringUtils.collectionToDelimitedString(Arrays.asList("a","b","c"),";");
        assertEquals("a;b;c",result2);
    }

    /* 把集合中的每个元素使用指定前后缀包裹，然后使用指定字符串拼接 */
    @Test
    public void collectionToDelimitedString2(){
        String result = StringUtils.collectionToDelimitedString(Arrays.asList("a","b","c"),",","[","]");
        assertEquals("[a],[b],[c]",result);
    }

    /* 将逗号拼接字符串转换为集合 */
    @Test
    public void commaDelimitedListToSet(){
        Set<String> result = StringUtils.commaDelimitedListToSet("a,b,c");
        assertEquals(3,result.size());
        assertTrue(result.contains("a"));
        assertTrue(result.contains("b"));
        assertTrue(result.contains("c"));
    }

    /* 将逗号拼接字符串转换为字符串数组 */
    @Test
    public void commaDelimitedListToStringArray(){
        String[] result = StringUtils.commaDelimitedListToStringArray("a,b,c");
        assertEquals(3,result.length);
        assertEquals("a",result[0]);
        assertEquals("b",result[1]);
        assertEquals("c",result[2]);
    }

    /* 将给定数组拼接，同样元素包含两次，保留原数组中元素顺序 */
    @Test
    public void concatenateStringArrays(){
        String[] arr1 = new String[]{"a","b","c"};
        String[] arr2 = new String[]{"1","2","3"};
        String[] result = StringUtils.concatenateStringArrays(arr1,arr2);
        assertEquals(6,result.length);
        assertEquals("1",result[3]);
        assertEquals("2",result[4]);
        assertEquals("3",result[5]);
    }

    /* 字符串是否包含空白 */
    @Test
    public void containsWhitespace(){
        assertTrue(StringUtils.containsWhitespace(" adasd"));
        assertTrue(StringUtils.containsWhitespace("adasd "));
        assertTrue(StringUtils.containsWhitespace("ada  sd"));
        assertFalse(StringUtils.containsWhitespace("adasd"));
    }

    /* 包含了多少个子字符串 */
    @Test
    public void countOccurrencesOf(){
        int count1 =  StringUtils.countOccurrencesOf("banana","a");
        assertEquals(3,count1);
        int count2 =  StringUtils.countOccurrencesOf("banana","n");
        assertEquals(2,count2);
        int count3 =  StringUtils.countOccurrencesOf("banana","b");
        assertEquals(1,count3);
    }

    /* 从字符串中删除指定模式字符串 */
    @Test
    public void delete(){
        String result1 = StringUtils.delete("nabanana","na");
        assertEquals("ba",result1);
    }

}
