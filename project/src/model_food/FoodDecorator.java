package model_food;

public abstract class FoodDecorator implements Food {
	protected Food food;
	
	public FoodDecorator(Food food) {
		super();
		this.food = food;
	}

	public abstract double cost();
}