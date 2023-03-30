package starbuzz_caffe;

public class DarkRoast extends Beverage {
	public DarkRoast(Size size) {
		super(size);
	}
	
	public DarkRoast() {
	}

	public double cost() {
		return this.size.getPercent()*0.99;
	}
}