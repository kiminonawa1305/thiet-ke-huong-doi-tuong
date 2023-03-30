package starbuzz_caffe;

public class Soy extends CondimentDecorator {

	public Soy(String description, Size size, Beverage beveage) {
		super(description, size, beveage);
		// TODO Auto-generated constructor stub
	}
	
	public Soy(String description, Beverage beveage) {
		super(description, beveage);
		// TODO Auto-generated constructor stub
	}

	public double cost() {
		return this.size.getPercent()*0.15 + beveage.cost();
	}

}