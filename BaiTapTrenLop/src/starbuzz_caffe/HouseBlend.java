package starbuzz_caffe;

public class HouseBlend extends Beverage {

	public HouseBlend(Size size) {
		super(size);
		// TODO Auto-generated constructor stub
	}
	
	public HouseBlend() {
	}

	public double cost() {
		return this.size.getPercent()*0.89;
	}
}