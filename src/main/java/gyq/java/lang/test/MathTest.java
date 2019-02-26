package gyq.java.lang.test;

import java.math.BigDecimal;

/**
 * @author Asa
 * @version 创建时间：2016年8月22日 下午12:32:20
 */
public class MathTest {
	// public static void main(String[] args) {
	// int x1=10;
	// long x2 = 12000;
	// long x3 = 120000;
	// double x4= x1;
	// System.out.println(Math.ceil(
	// (double)x1*(x3-x2)/x3)
	// );
	// }
	public static void main(String[] args) {
		double i = 2, j = 2.1, k = 2.5, m = 2.9;
		System.out.println("舍掉小数取整:Math.floor(2)=" + (int) Math.floor(i));
		System.out.println("舍掉小数取整:Math.floor(2.1)=" + (int) Math.floor(j));
		System.out.println("舍掉小数取整:Math.floor(2.5)=" + (int) Math.floor(k));
		System.out.println("舍掉小数取整:Math.floor(2.9)=" + (int) Math.floor(m));

		/* 这段被注释的代码不能正确的实现四舍五入取整 */
		// System.out.println("四舍五入取整:Math.rint(2)=" + (int)Math.rint(i));
		// System.out.println("四舍五入取整:Math.rint(2.1)=" + (int)Math.rint(j));
		// System.out.println("四舍五入取整:Math.rint(2.5)=" + (int)Math.rint(k));
		// System.out.println("四舍五入取整:Math.rint(2.9)=" + (int)Math.rint(m));
		//
		// System.out.println("四舍五入取整:(2)=" + new DecimalFormat("0").format(i));
		// System.out.println("四舍五入取整:(2.1)=" + new DecimalFormat("0").format(i));
		// System.out.println("四舍五入取整:(2.5)=" + new DecimalFormat("0").format(i));
		// System.out.println("四舍五入取整:(2.9)=" + new DecimalFormat("0").format(i));
		System.out.println("小数点后第一位=5");
		System.out.println("正数：Math.round(11.5)=" + Math.round(11.5));
		System.out.println("负数：Math.round(-11.5)=" + Math.round(-11.5));

		System.out.println("小数点后第一位<5");
		System.out.println("正数：Math.round(11.46)=" + Math.round(11.46));
		System.out.println("负数：Math.round(-11.46)=" + Math.round(-11.46));

		System.out.println("小数点后第一位>5");
		System.out.println("正数：Math.round(11.68)=" + Math.round(11.68));
		System.out.println("负数：Math.round(-11.68)=" + Math.round(-11.68));

		System.out.println("四舍五入取整:(2)=" + new BigDecimal("2").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(2.1)=" + new BigDecimal("2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(2.5)=" + new BigDecimal("2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(2.9)=" + new BigDecimal("2.9").setScale(0, BigDecimal.ROUND_HALF_UP));

		System.out.println("凑整:Math.ceil(2)=" + (int) Math.ceil(i));
		System.out.println("凑整:Math.ceil(2.1)=" + (int) Math.ceil(j));
		System.out.println("凑整:Math.ceil(2.5)=" + (int) Math.ceil(k));
		System.out.println("凑整:Math.ceil(2.9)=" + (int) Math.ceil(m));

		System.out.println("舍掉小数取整:Math.floor(-2)=" + (int) Math.floor(-i));
		System.out.println("舍掉小数取整:Math.floor(-2.1)=" + (int) Math.floor(-j));
		System.out.println("舍掉小数取整:Math.floor(-2.5)=" + (int) Math.floor(-k));
		System.out.println("舍掉小数取整:Math.floor(-2.9)=" + (int) Math.floor(-m));

		System.out.println("四舍五入取整:(-2)=" + new BigDecimal("-2").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(-2.1)=" + new BigDecimal("-2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(-2.5)=" + new BigDecimal("-2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(-2.9)=" + new BigDecimal("-2.9").setScale(0, BigDecimal.ROUND_HALF_UP));

		System.out.println("凑整:Math.ceil(-2)=" + (int) Math.ceil(-i));
		System.out.println("凑整:Math.ceil(-2.1)=" + (int) Math.ceil(-j));
		System.out.println("凑整:Math.ceil(-2.5)=" + (int) Math.ceil(-k));
		System.out.println("凑整:Math.ceil(-2.9)=" + (int) Math.ceil(-m));
	}
}
