package gyq.java.guava;

import com.google.common.collect.HashBiMap;

/**
 * @author geyingqi
 * @date 2019-09-24 11:46
 */
public class BiMapTest {
    public static void main(String[] args) {
        HashBiMap<Object, Object> hashBiMap = HashBiMap.create();
        hashBiMap.put(1, 2);
        Object value = hashBiMap.get(1);
        // 当你创建BiMap的时候，在内部维护了2个map，一个forward map，一个backward map，并且设置了它们之间的关系。
        // 因此，biMap.inverse() != biMap ； biMap.inverse().inverse() == biMap
        Object key = hashBiMap.inverse().get(2);
        System.out.println(value);
        System.out.println(key);
    }
}
