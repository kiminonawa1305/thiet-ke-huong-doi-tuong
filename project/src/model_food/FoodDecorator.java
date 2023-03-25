package model_food;

public abstract class FoodDecorator implements Food {
	protected Food food;
	
	public abstract double cost();
	
	@Override
	public String toString() {
		return this.note();
	}

	public abstract String getName();
}