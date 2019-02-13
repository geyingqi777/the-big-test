package gyq.java.lang.test;

public class IsInstanceTest {
	public static void main(String[] args) {
		D d = new D();
		C c = new C();
		C ba = new D();
		System.out.println("1------------");
		System.out.println(d instanceof D);
		System.out.println(d instanceof C);
		System.out.println(d instanceof Object);
		System.out.println(null instanceof Object);
		System.out.println("2------------");
		System.out.println(d.getClass().isInstance(d));
		System.out.println(d.getClass().isInstance(c));
		System.out.println("3------------");
		System.out.println(c.getClass().isInstance(ba));
		System.out.println(d.getClass().isInstance(ba));
		System.out.println(d.getClass().isInstance(null));
		System.out.println("4------------");
		System.out.println(C.class.isInstance(c));
		System.out.println(C.class.isInstance(d));
		System.out.println(C.class.isInstance(ba));
		System.out.println("5------------");
		System.out.println(D.class.isInstance(c));
		System.out.println(D.class.isInstance(d));
		System.out.println(D.class.isInstance(ba));
		System.out.println("6------------");
		System.out.println(Object.class.isInstance(d));
		System.out.println(Object.class.isInstance(null));
	}

	static class C {
	}

	static class D extends C {
	}

}