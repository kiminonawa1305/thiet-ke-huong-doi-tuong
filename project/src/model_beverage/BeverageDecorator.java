package model_beverage;

public abstract class BeverageDecorator implements Beverage {
	protected Beverage beverage;
	protected double cost;
	protected String name;

	public abstract double cost();

	@Override
	public String toString() {
		return this.note();
	}

	public Beverage getBeverage() {
		return beverage;
	}

	public Beverage setBeverage(Beverage beverage) {
		this.beverage = beverage;
		return this;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}