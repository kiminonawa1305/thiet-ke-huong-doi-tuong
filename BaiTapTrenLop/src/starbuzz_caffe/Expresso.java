package starbuzz_caffe;

public class Expresso extends Beverage {

	public Expresso(Size size) {
		super(size);
	}
	
	public Expresso() {
	}

	public double cost() {
		return this.size.getPercent()*1.989;
	}
}