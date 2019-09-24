package gyq.java.langtest;

/**
 * Created by Asa on 2019-01-29.
 */
public class FloatDoubleTest {
	public static void main(String[] args) {
		int i = 7;
		float f = 0.1f;
		double d = 0.1d;
		int i2 = 130;
		float v = i * f * i2;
		double v1 = i * d * i2;
		System.out.println(v);
		System.out.println(v1);
		System.out.println(Math.ceil(v));
		System.out.println(Math.ceil(v1));
	}
}
