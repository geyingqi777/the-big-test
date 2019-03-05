package gyq.java.design_pattern.factory.simple;

/**
 * Created by ge_yi on 2019/3/5.
 */
public class SimpleFactoryTest {
	public static void main(String[] args) {
		/**
		 * 简单工厂模式
		 */
		INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_GK);
		noodles.desc();
	}
}
