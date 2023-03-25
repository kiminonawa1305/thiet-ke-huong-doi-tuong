package model_food;

public class Cheese extends FoodDecorator {
	public Cheese(Food food) {
		this.food = food;
	}

	public double cost() {
		return 2000 + food.cost();
	}

	@Override
	public String note() {
		return food.note() + " thêm phô mai,";
	}

	@Override
	public String getName() {
		return "Phô mai";
	}

}