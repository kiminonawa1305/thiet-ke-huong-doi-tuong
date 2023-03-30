package starbuzz_caffe;

public class Whip extends CondimentDecorator {

	public Whip(String description, Size size, Beverage beveage) {
		super(description, size, beveage);
	}
	
	public Whip(String description, Beverage beveage) {
		super(description, beveage);
	}

	public double cost() {
		return this.size.getPercent()*0.1 + beveage.cost();
	}

}