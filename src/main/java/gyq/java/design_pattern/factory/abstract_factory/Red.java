package gyq.java.design_pattern.factory.abstract_factory;

public class Red implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}