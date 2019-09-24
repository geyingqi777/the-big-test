package gyq.java.designpattern.factory.abstractfactory;

public class Green implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Green::fill() method.");
	}
}