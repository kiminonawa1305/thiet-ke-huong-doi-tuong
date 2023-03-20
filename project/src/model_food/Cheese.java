package model_food;

public class Cheese extends FoodDecorator {
	public Cheese(Food food) {
		super(food);
	}

	public double cost() {
		return 2000 + food.cost();
	}

	@Override
	public String note() {
		return food.note() + " thêm phô mai,";
	}

}