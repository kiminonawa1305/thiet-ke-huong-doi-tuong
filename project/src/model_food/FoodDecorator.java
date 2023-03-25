package model_food;

public abstract class FoodDecorator implements Food {
	protected Food food;
	protected String name;
	protected double cost;
	
	public abstract double cost();
	
	@Override
	public String toString() {
		return this.note();
	}

	public abstract String getName();

	public Food setFood(Food foodOrder) {
		this.food = foodOrder;
		return this;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Food getFood() {
		return food;
	}

	public void setName(String name) {
		this.name = name;
	}
}