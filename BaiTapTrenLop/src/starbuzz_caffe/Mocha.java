package starbuzz_caffe;

public class Mocha extends CondimentDecorator {
	public Mocha(String description, Size size, Beverage beveage) {
		super(description, size, beveage);
		// TODO Auto-generated constructor stub
	}
	
	public Mocha(String description, Beverage beveage) {
		super(description, beveage);
		// TODO Auto-generated constructor stub
	}

	public double cost() {
		return this.size.getPercent()*0.2 + beveage.cost();
	}

}