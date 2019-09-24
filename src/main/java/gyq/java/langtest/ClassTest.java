package gyq.java.langtest;

/**
 * class对象的一些方法的测试 Createb by ge_yi on 2019/2/13.
 */
public class ClassTest {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		A ba = new B();
		System.out.println("1-------------");
		// isAssignableFrom,当调用者是父类或者父接口的时候,返回true
		System.out.println(A.class.isAssignableFrom(a.getClass()));
		System.out.println(B.class.isAssignableFrom(b.getClass()));
		System.out.println(A.class.isAssignableFrom(b.getClass()));
		System.out.println(B.class.isAssignableFrom(a.getClass()));
		System.out.println(A.class.isAssignableFrom(ba.getClass()));
		System.out.println(B.class.isAssignableFrom(ba.getClass()));
		System.out.println("2-------------");
		System.out.println(a.getClass().isAssignableFrom(A.class));
		System.out.println(b.getClass().isAssignableFrom(B.class));
		System.out.println(a.getClass().isAssignableFrom(B.class));
		System.out.println(b.getClass().isAssignableFrom(A.class));
		System.out.println(ba.getClass().isAssignableFrom(A.class));
		System.out.println(ba.getClass().isAssignableFrom(B.class));
		System.out.println("3-------------");
		System.out.println(Object.class.isAssignableFrom(b.getClass()));
		System.out.println(Object.class.isAssignableFrom("abc".getClass()));
		System.out.println("4-------------");
		System.out.println("a".getClass().isAssignableFrom(Object.class));
		System.out.println("abc".getClass().isAssignableFrom(Object.class));

		// isInstance方法的测试
		System.out.println("1------------");
		System.out.println(b instanceof B);
		System.out.println(b instanceof A);
		System.out.println(b instanceof Object);
		System.out.println(null instanceof Object);
		System.out.println("2------------");
		System.out.println(b.getClass().isInstance(b));
		System.out.println(b.getClass().isInstance(a));
		System.out.println("3------------");
		System.out.println(a.getClass().isInstance(ba));
		System.out.println(b.getClass().isInstance(ba));
		System.out.println(b.getClass().isInstance(null));
		System.out.println("4------------");
		System.out.println(A.class.isInstance(a));
		System.out.println(A.class.isInstance(b));
		System.out.println(A.class.isInstance(ba));
		System.out.println("5------------");
		System.out.println(B.class.isInstance(a));
		System.out.println(B.class.isInstance(b));
		System.out.println(B.class.isInstance(ba));
		System.out.println("6------------");
		System.out.println(Object.class.isInstance(b));
		System.out.println(Object.class.isInstance(null));
	}

	private static class A {
	}

	private static class B extends A {
	}
}
