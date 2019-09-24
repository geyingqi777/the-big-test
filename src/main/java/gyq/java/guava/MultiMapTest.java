package gyq.java.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.TreeMultimap;

/**
 * @author geyingqi
 * @date 2019-09-23 15:23
 */
public class MultiMapTest {
    public static void main(String[] args) {
        ArrayListMultimap<Object, Object> arrayListMultimap = ArrayListMultimap.create();
        arrayListMultimap.put(1, 1);
        arrayListMultimap.put(1, 2);
        arrayListMultimap.put(1, 2);
        arrayListMultimap.put(2, 2);
        System.out.println(JSON.toJSONString(arrayListMultimap));
        HashMultimap<Object, Object> hashMultimap = HashMultimap.create();
        hashMultimap.put(1, 1);
        hashMultimap.put(1, 2);
        // 这里只会留下一个,相当于map里的value是hashset
        hashMultimap.put(1, 2);
        hashMultimap.put(2, 3);
        System.out.println(JSON.toJSONString(hashMultimap));
        // 用linkedlist实现
        LinkedListMultimap<Object, Object> linkedListMultimap = LinkedListMultimap.create();
        // 用linkedhashset实现
        LinkedHashMultimap<Object, Object> linkedHashMultimap = LinkedHashMultimap.create();
        // 用treeset实现
        TreeMultimap<Comparable, Comparable> treeMultimap = TreeMultimap.create();
        // 不可变的
        ImmutableMultimap<Object, Object> immutableMultimap = ImmutableMultimap.of();
        // 用linkedhashset实现
        LinkedHashMultiset<Object> linkedHashMultiset = LinkedHashMultiset.create();
        
    }
}
