package gyq.java.lang.test;

import java.util.Date;

/**
 * Created by ge_yi on 2018/4/20.
 */
public class StringFormatTest {
	public static void main(String[] args) {
		String format = String.format("%c", 'a');
		System.out.println(format);

		String str = null;
		// $使用
		str = String.format("格式参数$的使用：%1$d,%2$s", 99, "abc");
		System.out.println(str);
		// +使用
		System.out.printf("显示正负数的符号：%+d与%d%n", 99, -99);
		// 补O使用
		System.out.printf("最牛的编号是：%03d%n", 7);
		// 空格使用
		System.out.printf("空格键的效果是：% 8d%n", 7);
		// .使用
		System.out.printf("整数分组的效果是：%,d%n", 9989997);
		// 空格和小数点后面个数
		System.out.printf("一本书的价格是：% 50.5f元%n", 49.8);

		Date date = new Date();
		// c的使用
		System.out.printf("全部日期和时间信息：%tc%n", date);
		// f的使用
		System.out.printf("年-月-日格式：%tF%n", date);
		// d的使用
		System.out.printf("月/日/年格式：%tD%n", date);
		// r的使用
		System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n", date);
		// t的使用
		System.out.printf("HH:MM:SS格式（24时制）：%tT%n", date);
		// R的使用
		System.out.printf("HH:MM格式（24时制）：%tR", date);
	}
}
