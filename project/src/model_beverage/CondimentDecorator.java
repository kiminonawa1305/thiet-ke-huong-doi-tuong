package model_beverage;

public abstract class CondimentDecorator implements Beverage {
	protected Beverage beverage;
	
	public CondimentDecorator(Beverage beverage) {
		super();
		this.beverage = beverage;
	}



	public abstract double cost();

}