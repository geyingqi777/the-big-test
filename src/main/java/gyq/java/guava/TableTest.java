package gyq.java.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * @author geyingqi
 * @date 2019-09-27 17:28
 */
public class TableTest {
    @Test
    public void test1() {
        // 一个支持横纵坐标的表格式数据结构
        HashBasedTable<Object, Object, Object> hashBasedTable = HashBasedTable.create();
        hashBasedTable.put(1, 1, "value1");
        hashBasedTable.put(1, 2, "value2");
        hashBasedTable.put(2, 1, "value3");
        hashBasedTable.put(2, 2, "value4");
        // 这样会得到{"empty":false}, 打印不出里面的值来
        System.out.println(JSON.toJSONString(hashBasedTable));

        System.out.println("按cell打印");
        // table中每个cell的set
        Set<Table.Cell<Object, Object, Object>> cellSet = hashBasedTable.cellSet();
        for (Table.Cell<Object, Object, Object> objectCell : cellSet) {
            System.out.println(JSON.toJSONString(objectCell));
        }
        System.out.println("按行打印");
        // 获取行的集合
        Set<Object> rowKeySet = hashBasedTable.rowKeySet();
        for (Object o : rowKeySet) {
            Map<Object, Object> map = hashBasedTable.row(o);
            System.out.println(JSON.toJSONString(map));
        }
        System.out.println("按列打印");
        // 获取列的集合
        Set<Object> columnKeySet = hashBasedTable.columnKeySet();
        for (Object o : columnKeySet) {
            Map<Object, Object> map = hashBasedTable.column(o);
            System.out.println(JSON.toJSONString(map));
        }

    }
}
