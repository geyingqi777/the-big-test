package gyq.java.lang.test;

import java.math.BigDecimal;

/**
 * Created by Asa on 2019-01-29.
 */
public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal bigDecimal1 = BigDecimal.valueOf(0.1d);
		BigDecimal bigDecimal2 = BigDecimal.valueOf(7);
		BigDecimal bigDecimal3 = BigDecimal.valueOf(130);
		BigDecimal multiply = bigDecimal1.multiply(bigDecimal2).multiply(bigDecimal3);
		double v = multiply.doubleValue();
		System.out.println(v);
		System.out.println(Math.ceil(v));
	}
}
