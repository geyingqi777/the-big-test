package gyq.java.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 测试一下guava里的joiner的特性
 *
 * @author geyingqi
 * @date 2019-09-20 15:26
 */

public class JoinerTest {

    
    public void test1() {

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add(null);
        list.add("");
        // 集合转string
        Joiner joiner = Joiner.on(",");
        // 跳过空元素
        String join = joiner.skipNulls().join(list);
        // 空元素指定为默认值
        String join2 = joiner.useForNull("空").join(list);
        System.out.println(join);
        System.out.println(join2);
        // 把字符串转成集合
        Splitter splitter = Splitter.on(",")
                // 拆分字符串后，自动去掉空的字符串
                .omitEmptyStrings()
                // 拆了之后trim一下空格或者其他指定的字符
                .trimResults(CharMatcher.whitespace());
        List<String> list1 = splitter.splitToList(join);
        List<String> list2 = splitter.splitToList(join2);
        Iterable<String> stringIterable = splitter.split(join2);
        System.out.println(JSON.toJSONString(list1));
        System.out.println(JSON.toJSONString(list2));
        // map格式的
        Map<String, String> immutableMap = ImmutableMap.of("id", "123", "name", "green");
        Joiner.MapJoiner mapJoiner = Joiner.on("&").withKeyValueSeparator("=");
        String stringMap = mapJoiner.join(immutableMap);
        System.out.println(stringMap);
        Splitter.MapSplitter mapSplitter = Splitter.on("&").withKeyValueSeparator("=");
        Map<String, String> splitMap = mapSplitter.split(stringMap);
        System.out.println(JSON.toJSONString(splitMap));

        String orderNos = "1 ";
        List<String> splitToList = splitter.splitToList(orderNos);
        System.out.println(JSON.toJSONString(splitToList));
    }
}
