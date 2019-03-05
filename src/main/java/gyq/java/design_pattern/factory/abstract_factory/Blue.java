package gyq.java.design_pattern.factory.abstract_factory;

public class Blue implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Blue::fill() method.");
	}
}