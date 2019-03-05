package gyq.java.lang.test;

import org.apache.commons.lang.math.RandomUtils;

/**
 * @author Asa
 * @version 创建时间：2016年8月2日 下午4:20:41
 */
public class FloatTest {
	public static void main(String[] args) {
		float f = 1.1111f;
		float f1 = f / 0;
		float f2 = f1 / f1;
		float f3 = f1 / f1;
		System.out.println(Float.isNaN(f2));
		System.out.println(f2);
		System.out.println(f1 / 200);
		System.out.println(f / f1);
		System.out.println(f2 == f3);
		System.out.println(Float.compare(f2, f3) == 0);
		int i1 = 1;
		float f4 = (RandomUtils.nextInt(61) + 30) / 100F;
		System.out.println(f4);
		System.out.println((int) Math.ceil(i1 * f4));
		int count = 0;
		for (int i = 0; i < 100; i++) {
			if (RandomUtils.nextInt(100) < 10) {
				count++;
			}
		}
		System.out.println(count);
	}
}
