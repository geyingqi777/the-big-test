package gyq.java.langtest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Asa on 2017/5/17.
 */
public class ReflectTest {
	public static void main(String[] args) {
		Student st = new Student();
		// 返回此 Object 的运行时类，得到该对象的Class。
		Class clazz = st.getClass();

		/***
		 * getSuperclass()获得Student该类的父类Person的 完整类名。如：class com.test.Person
		 ***/
		System.out.println(clazz.getSuperclass());

		/**
		 * getGenericSuperclass()获得带有泛型的父类,方法的参数是子类Class，返回值是子类继承父类时给父类传入的泛型参数，并将其转换ParameterizedType。 该方法假定父类只有一个泛型参数，否则抛出异常。 简而言之就是获得超类的泛型参数的实际类型。
		 * 结果为com.test.Person<com.test.Student>
		 *
		 * Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
		 */
		Type type = clazz.getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		// getActualTypeArguments()获取参数化类型，返回一个数组，因为获取的参数化类型可能有多个
		Class c = (Class) parameterizedType.getActualTypeArguments()[0];
		System.out.println(c);
	}
}
