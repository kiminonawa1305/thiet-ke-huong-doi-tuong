package starbuzz_caffe;

public class Decaf extends Beverage {

	public Decaf(Size size) {
		super(size);
		// TODO Auto-generated constructor stub
	}
	
	public Decaf() {
	}


	public double cost() {
		return this.size.getPercent()*1.05;
	}
}