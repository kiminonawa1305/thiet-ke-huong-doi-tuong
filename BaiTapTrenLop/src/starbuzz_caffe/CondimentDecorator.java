package starbuzz_caffe;

public abstract class CondimentDecorator extends Beverage {
	protected Beverage beveage;
	
	public CondimentDecorator(String description, Size size, Beverage beveage) {
		super(size);
		this.description = description;
		this.beveage = beveage;
	}
	
	public CondimentDecorator(String description, Beverage beveage) {
		this.description = description;
		this.beveage = beveage;
	}

	@Override
	public abstract double cost();
}