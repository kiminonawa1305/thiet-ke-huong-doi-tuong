package starbuzz_caffe;

public class Milk extends CondimentDecorator {

	public Milk(String description, Size size, Beverage beveage) {
		super(description, size, beveage);
		// TODO Auto-generated constructor stub
	}
	
	public Milk(String description, Beverage beveage) {
		super(description, beveage);
		// TODO Auto-generated constructor stub
	}

	public double cost() {
		return this.size.getPercent()*0.1 + beveage.cost();
	}

}