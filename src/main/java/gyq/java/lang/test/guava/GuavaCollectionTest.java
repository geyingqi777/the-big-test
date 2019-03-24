package gyq.java.lang.test.guava;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * guava的集合相关功能的学习
 * <p>
 * Created by geyingqi on 2019-03-24 14:53.
 */
public class GuavaCollectionTest {
    public static void main(String[] args) {
        // 方便地创建一个不可变的set,list等
        ImmutableSet<Integer> immutableSet = ImmutableSet.of(1, 2, 3, 4, 5);
        // 元素里有null的时候,运行时会出现NullPointerException
        // ImmutableSet<Integer> immutableSet1 = ImmutableSet.of(1, 2, 3, 4, null);
        // ImmutableSet<? extends Serializable> immutableSet2 = ImmutableSet.of(1, 2, "11", Optional.absent(), null);
        ImmutableSet<? extends Serializable> immutableSet2 = ImmutableSet.of(1, 2, "11", Optional.absent());
        ImmutableList<Integer> immutableList = ImmutableList.of(1, 2, 3);
        // 其中的元素不是同样数据类型时,会用泛型
        ImmutableMap<? extends Serializable, ? extends Serializable> immutableMap = ImmutableMap.of(1, 2, "1", "2");
        for (Map.Entry<? extends Serializable, ? extends Serializable> entry : immutableMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
    }
}
